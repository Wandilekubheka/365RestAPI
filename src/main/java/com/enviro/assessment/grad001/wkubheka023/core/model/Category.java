package com.enviro.assessment.grad001.wkubheka023.core.model;

import jakarta.persistence.*;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;

    @Column(nullable = false, length = 50)
    private String categoryName;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String disposalMethod;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String recycleTips;

    // Getters and Setters
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDisposalMethod() {
        return disposalMethod;
    }

    public void setDisposalMethod(String disposalMethod) {
        this.disposalMethod = disposalMethod;
    }

    public String getRecycleTips() {
        return recycleTips;
    }

    public void setRecycleTips(String recycleTips) {
        this.recycleTips = recycleTips;
    }
}
