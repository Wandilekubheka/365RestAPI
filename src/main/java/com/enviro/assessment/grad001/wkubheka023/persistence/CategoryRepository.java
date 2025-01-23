package com.enviro.assessment.grad001.wkubheka023.persistence;

import com.enviro.assessment.grad001.wkubheka023.core.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    public Category findByCategoryName(String name);
}
