package com.enviro.assessment.grad001.wkubheka023.service.model;

public class Waste {
    private final int id;
    private final String name;
    private final Category category;
    public  Waste(int id, String name, Category category) {
        this.id = id;
        this.name = name;
        this.category = category;

    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
