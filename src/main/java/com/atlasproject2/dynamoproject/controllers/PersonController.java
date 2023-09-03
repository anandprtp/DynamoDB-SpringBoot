package com.atlasproject2.dynamoproject.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atlasproject2.dynamoproject.entity.Person;
import com.atlasproject2.dynamoproject.repository.PersonRepository;

@RequestMapping("/persons")
@RestController
public class PersonController {
    
    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    public List<Person> findAll(){
        return personRepository.findAll();
    }   
    @GetMapping("/{id}")
    public Person findById(@PathVariable(value="id") String id){
        return personRepository.findById(id);
    }
    @PostMapping
    public Person save(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable(value="id") String id, @RequestBody Person person) {
        return personRepository.update(id,person); 
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable(value="id") String id) {
        return personRepository.delete(id);
    }

    @PostMapping("/incrementAge/{id}")
    public String update1(@PathVariable(value = "id") String id, Person person) {
        personRepository.incrementAge(id);
        return id;
    }
}
