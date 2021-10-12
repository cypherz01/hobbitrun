package com.example.hobbitrun.model;

/*
    superpowers:
    - DRM/JPA/Hibernate entity

 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Hobbit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firsName;
    private String lastName;

    public Hobbit() {
    }

    public Hobbit(Long id, String firsName, String lastName) {
        this.id = id;
        this.firsName = firsName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
