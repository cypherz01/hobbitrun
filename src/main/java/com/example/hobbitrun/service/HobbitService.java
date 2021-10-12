package com.example.hobbitrun.service;

import com.example.hobbitrun.model.Hobbit;
import com.example.hobbitrun.repository.HobbitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/*
    superpowers:
    - spring component aka spring bean
    - recognize the app's layer

 */

@Service
public class HobbitService {

    private HobbitRepository hobbitRepository;

    public HobbitService(HobbitRepository hobbitRepository) {
        this.hobbitRepository = hobbitRepository;
    }

    public List<Hobbit> getAll() {
        return hobbitRepository.findAll();
    }

}
