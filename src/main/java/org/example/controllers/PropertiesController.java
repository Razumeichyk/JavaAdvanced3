package org.example.controllers;

import org.example.config.Info;
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

    @Autowired
    private Person person;

    @Autowired
    private Info info;

    @GetMapping("/category")
    public PropertiesCategory category(){
        return propertiesCategory;
    }

    @GetMapping("/person")
    public Person getPerson(){
        System.out.println(person.getVisitor().getAge());
        return person;
    }

    @GetMapping("/info")
    public Info getInfo(){
        return info;
    }
}
