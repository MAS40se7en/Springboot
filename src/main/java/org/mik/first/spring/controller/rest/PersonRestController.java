package org.mik.first.spring.controller.rest;

import lombok.NonNull;
import org.mik.first.spring.Const;
import org.mik.first.spring.domain.Person;
import org.mik.first.spring.service.CountryService;
import org.mik.first.spring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import javax.print.attribute.standard.Media;
import java.util.List;

@Controller
@RequestMapping(Const.REST_API_URL+"/person")
public class PersonRestController {

    private final PersonService personService;

    private final CountryService countryService;

    @Autowired
    public PersonRestController(PersonService personService,
                                    CountryService countryService
                                ) {
        this.personService=personService;
        this.countryService=countryService;
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Person>> getAll() {
        List<Person> result = this.personService.getAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> getById(@NonNull @PathVariable(required = true) Long id) {
        return ResponseEntity.ok(this.personService.findById(id).orElseThrow( ()->new ResourceNotFoundException(String.format("Cannot find person with id: %d", id))));
    }

    @PostMapping(value = "/add/{countryId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> add(@RequestBody Person p, @PathVariable(required = false) Long countryId) {
        if (p.getId()!=null) {
            throw new ResourceAlreadyExistsException("Cannot insert person with id");
        }
        if (p.getCountry()!=null) {
            if (countryId==null) {
                    throw new ResourceNotFoundException("No country defined for person");

            }
            p.setCountry(this.countryService.findById(countryId).orElseThrow(
                        () -> new ResourceNotFoundException(String.format("Cannot find country with id: %d", countryId))
            ));
        }


        return ResponseEntity.ok(this.personService.save(p));
    }
}
