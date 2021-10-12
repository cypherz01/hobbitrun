package com.example.hobbitrun.service;

import com.example.hobbitrun.model.Hobbit;
import org.springframework.stereotype.Service;

import java.util.List;

/*
    superpowers:
    - spring component aka spring bean
    - recognize the app's layer

 */

@Service
public class HobbitService {

    public List<Hobbit> getAll() {
        return List.of(
                new Hobbit(1L,"Frodo","Baggins"),
                new Hobbit(2L,"Billbo","Baggins"),
                new Hobbit(3L,"Penelope","Tuk")
        );
    }

}
