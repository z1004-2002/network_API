package com.vetrix.network_API.project.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public List<Person> getPerson(){
        return repository.findAll();
    }
    public List<Person> getPersonByPhone(String phone){
        return repository.getByPhone(phone);
    }
    public Optional<Person> getPersonById(UUID id){
        return repository.findById(id);
    }
    public Person addPerson(Person person){
        repository.save(person);
        return person;
    }
}
