package com.enviro.assessment.grad001.wkubheka023.controller;

import com.enviro.assessment.grad001.wkubheka023.core.errors.ActionErrors;
import com.enviro.assessment.grad001.wkubheka023.core.model.Category;
import com.enviro.assessment.grad001.wkubheka023.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // Get all categories
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    // Get a category by ID
    @GetMapping("/id/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable int id) throws ActionErrors {
        Category category = categoryService.getCategoryById(id);
        return ResponseEntity.ok(category);
    }

    // Controller method to get a category by name
    @GetMapping("/name/{name}")
    public ResponseEntity<Category> getCategoryByName(@PathVariable String name) throws ActionErrors {
        Category category = categoryService.getCategoryByName(name);
        if (category == null) {
            throw new ActionErrors("Category not found: " + name);
        }
        return ResponseEntity.ok(category);
    }

    // Create a new category
    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) throws ActionErrors {
        Category createdCategory = categoryService.createCategory(category);
        return ResponseEntity.ok(createdCategory);
    }

    // Update an existing category
    @PutMapping()
    public ResponseEntity<Category> updateCategory( @RequestBody Category category) throws ActionErrors {
        Category updatedCategory = categoryService.updateCategory(category);
        return ResponseEntity.ok(updatedCategory);
    }

    // Delete a category by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable int id) throws ActionErrors {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
