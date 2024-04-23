package org.mik.first.spring.controller.web;

import lombok.extern.log4j.Log4j2;
import org.mik.first.spring.domain.Person;
import org.mik.first.spring.service.CountryService;
import org.mik.first.spring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@Log4j2
@RequestMapping("/person")
public class PersonController {
    private final PersonService personService;

    private final CountryService countryService;

    @Autowired
    public PersonController(PersonService personService,
                            CountryService countryService){
        this.countryService = countryService;
        this.personService = personService;
    }

    @GetMapping("/list")
    public String list(Model model,
                       @RequestParam("page")Optional<Integer> page,
                       @RequestParam("size")Optional<Integer> size){
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);
        Page<Person> result = personService.getAll(PageRequest.of(currentPage - 1, pageSize));
        int totalPages = result.getTotalPages();
        if(totalPages > 0){
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("persons", result);
        return "person-list";
    }

    @GetMapping("/insert-form")
    public String insertForm(Model model){
        try{
            model.addAttribute("countries", this.countryService.getAll());
            return "person-insert";
        }catch (Exception e){
            log.error(e.getMessage());
            return "person-list";
        }
    }

    @GetMapping("/update-form/{id}")
    public String updateForm(@PathVariable("id") Long id, Model model){
        AtomicReference<String> result = new AtomicReference<>();
        try {
            personService.findById(id).ifPresentOrElse(
                    p -> {
                        model.addAttribute("person", p);
                        model.addAttribute("countries", this.countryService.getAll());
                        result.set("/person-update");
                    },
                    ()-> result.set("redirect:/person-list")
            );
            return  result.get();
        }catch (Exception e){
            log.error(e.getMessage());
            return "person-list";
        }
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, @ModelAttribute Person person){
        try {
            this.personService.findById(id).ifPresentOrElse(
                    p->{
                        person.setId(p.getId());
                        person.setVersion(p.getVersion());
                        personService.save(person);
                    },
                    ()-> log.warn(String.format("Person %s not found", person))

            );
        }catch (Exception e){
            log.error(e.getMessage());

        }
        return "person-list";
    }

    @PostMapping("/insert")
    public String insert(@ModelAttribute Person person, Model model){
        try{
            personService.save(person);
        }
        catch (DataIntegrityViolationException dive){
            fillError(dive, "Data integrity validation error", model);
            return "person-insert";
        }
        catch (Exception e){
            fillError(e, "Server error", model);
        }
        return "redirect:person-list";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        try {
            this.personService.delete(id);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return "person-list";
    }
    private void fillError(Exception e, String message, Model model){
        log.error(e.getMessage());
        model.addAttribute("errors", List.of(message));
        model.addAttribute("countries", this.countryService.getAll());
    }
}
