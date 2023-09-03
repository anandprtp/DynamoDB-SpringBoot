package com.atlasproject2.dynamoproject.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/very")
public class HelloController {
    
    @RequestMapping("/hungry")
    public String hello() {
        return "I am Hungry!";
    }

    @GetMapping("/{name}")
    public String anand(@PathVariable(value = "name") String name) {
        return name;
    }
}
