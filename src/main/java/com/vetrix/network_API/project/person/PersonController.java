package com.vetrix.network_API.project.person;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/person")
@Tag(name = "User")
@CrossOrigin("*")
public class PersonController {
    private final PersonService service;
    @Autowired
    public PersonController(PersonService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public Person addPerson(@RequestBody Person person){
        return service.addPerson(person);
    }

    @GetMapping
    public List<Person> getPerson(){
        return service.getPerson();
    }
    @GetMapping("/{id}")
    public Optional<Person> getById(@PathVariable UUID id){
        return service.getPersonById(id);
    }
    @GetMapping("/phone/{phone}")
    public List<Person> getByPhone(@PathVariable String phone){
        return service.getPersonByPhone(phone);
    }
}
