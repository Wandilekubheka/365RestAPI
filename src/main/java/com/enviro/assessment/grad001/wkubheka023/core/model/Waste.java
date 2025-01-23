package com.enviro.assessment.grad001.wkubheka023.core.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Waste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String category;
    private  String description;


    public int getId() {
        return id;
    }



    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Waste waste = (Waste) o;
        return description.equals(waste.description) && category.equals(waste.category);
    }
}
