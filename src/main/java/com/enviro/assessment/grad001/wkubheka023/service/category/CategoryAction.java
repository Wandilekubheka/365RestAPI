package com.enviro.assessment.grad001.wkubheka023.service.category;

import com.enviro.assessment.grad001.wkubheka023.core.errors.ActionErrors;
import com.enviro.assessment.grad001.wkubheka023.core.model.Category;
import org.springframework.stereotype.Component;

import java.util.List;

public interface CategoryAction {
    public Category createCategory(Category category) throws ActionErrors;
    public Category deleteCategory( int categoryId)throws ActionErrors;
    public Category getCategoryByName(String categoryName)throws ActionErrors;
    public Category getCategoryById(int categoryId)throws ActionErrors;
    public List<Category> getAllCategories()throws ActionErrors;
}
