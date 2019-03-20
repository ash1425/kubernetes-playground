package com.ashay.trying.kub;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/people")
@Slf4j
public class PersonController {

    private final PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    public List<Person> getAll() {
        log.info("Getting all people");
        return personRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getByName(@PathVariable("id") String id) {
        log.info("Getting person by id : {}", id);

        return personRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> savePerson(@RequestBody Person person) {
        log.info("saving person : {}", person);
        Person saved = personRepository.save(person);

        return ResponseEntity.created(URI.create("/people/" + saved.getName())).build();
    }
}
