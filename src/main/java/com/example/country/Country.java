package com.example.country;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@DynamicUpdate
@Entity
@Table(name= "country")
public class Country {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
