package com.enviro.assessment.grad001.wkubheka023.persistence;

import com.enviro.assessment.grad001.wkubheka023.core.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    public Optional<Category> findByCategoryName(String name);
}
