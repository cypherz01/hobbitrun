package com.example.hobbitrun.controller;

import com.example.hobbitrun.model.Hobbit;
import com.example.hobbitrun.service.HobbitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
    superpowers:
    - spring component aka spring bean
    - spring mvc: easy integration with servlets

 */

@RestController
public class HobbitController {

    private final HobbitService service;

    public HobbitController(HobbitService service) {
        this.service = service;
    }

    @GetMapping("/hobbits")
    List<Hobbit> getAll() {
        return service.getAll();
    }

    @PostMapping("/hobbits")
    Hobbit save(@RequestBody Hobbit hobbit) {
        return service.save(hobbit);
    }
}
