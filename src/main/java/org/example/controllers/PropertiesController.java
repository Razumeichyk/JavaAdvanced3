package org.example.controllers;

import org.example.config.Person;
import org.example.config.PropertiesCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class PropertiesController {

    @Autowired
    private PropertiesCategory propertiesCategory;

    private Person person;

    @Autowired
    public void setPerson(Person person) {
        this.person = person;
    }

    @GetMapping("/category")
    public PropertiesCategory category(){
        return propertiesCategory;
    }

    @GetMapping("/person")
    public Person getPerson(){
        System.out.println(person.getVisitor().getAge());
        return person;
    }
}
