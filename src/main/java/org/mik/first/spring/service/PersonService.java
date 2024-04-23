package org.mik.first.spring.service;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.mik.first.spring.domain.Person;
import org.mik.first.spring.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Log4j2
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public Page<Person> getAll(Pageable pageable){
        return  this.personRepository.findAll(pageable);
    }


    public List<Person> getAll(){
        return this.personRepository.findAll();
    }
    public Optional<Person> findById(Long id) {
        return  this.personRepository.findById(id);
    }

    @Transactional
    public Person save(Person p) {
        return this.personRepository.save(p);
    }

    @Transactional
    public void delete(Long id) {
        this.personRepository.deleteById(id);
    }
}
