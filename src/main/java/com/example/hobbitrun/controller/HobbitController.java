package com.example.hobbitrun.controller;

import com.example.hobbitrun.model.Hobbit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
    superpowers:
    - spring component aka spring bean
    - spring mvc: easy integration with servlets

 */

@RestController
public class HobbitController {

    @GetMapping("/hobbits")
    List<Hobbit> getAll() {

        return List.of(
                new Hobbit(1L,"Frodo","Baggins"),
                new Hobbit(2L,"Billbo","Baggins"),
                new Hobbit(3L,"Penelope","Tuk")
        );
    }
}
