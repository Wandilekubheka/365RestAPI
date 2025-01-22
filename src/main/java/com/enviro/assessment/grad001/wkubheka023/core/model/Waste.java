package com.enviro.assessment.grad001.wkubheka023.core.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Waste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    @Enumerated(EnumType.STRING) // Store enum as a string in the database
    private Category category;
    private  String description;
    @ElementCollection
    private  List<String> disposalGuidelines;
    @ElementCollection
    private  List<String> recyclingTips;


    public int getId() {
        return id;
    }



    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getDisposalGuidelines() {
        return disposalGuidelines;
    }

    public void setDisposalGuidelines(List<String> disposalGuidelines) {
        this.disposalGuidelines = disposalGuidelines;
    }

    public List<String> getRecyclingTips() {
        return recyclingTips;
    }

    public void setRecyclingTips(List<String> recyclingTips) {
        this.recyclingTips = recyclingTips;
    }
}
