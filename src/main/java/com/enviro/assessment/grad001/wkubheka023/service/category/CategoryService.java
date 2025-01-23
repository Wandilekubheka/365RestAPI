package com.enviro.assessment.grad001.wkubheka023.service.category;

import com.enviro.assessment.grad001.wkubheka023.core.errors.ActionErrors;
import com.enviro.assessment.grad001.wkubheka023.core.model.Category;
import com.enviro.assessment.grad001.wkubheka023.persistence.CategoryRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class CategoryService implements CategoryAction {
    CategoryRepository categoryRepository;

    CategoryService(final CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    /**
     * @param category
     */
    @Override
    public Category createCategory(Category category) throws ActionErrors{
        List<Category> categories = getAllCategories();
        if (!categories.contains(category)) {
            return categoryRepository.save(category);
        }
        throw  new ActionErrors("Add waste failed, waste already exists");

    }

    public Category updateCategory(Category category) throws ActionErrors{
        return categoryRepository.save(category);
    }

    /**
     * @param category
     */
    @Override
    public Category deleteCategory(int categoryId) throws ActionErrors {
        try{
            Category category1 = getCategoryById(categoryId);
            categoryRepository.delete(category1);
            return category1;
        }catch (Exception e) {
            throw  new ActionErrors("Remove waste failed, waste does not exist");
        }
    }

    /**
     * @param categoryName
     * @return
     */
    @Override
    public Category getCategoryByName(String categoryName) throws ActionErrors{
       Optional<Category> category = categoryRepository.findByCategoryName(categoryName.toUpperCase());
       if (category.isPresent()) {
           return category.get();
       }
       throw  new ActionErrors("Get waste failed, waste does not exist");

    }

    /**
     * @param categoryId
     * @return
     */
    @Override
    public Category getCategoryById(int categoryId) throws ActionErrors {
        Optional<Category> category = categoryRepository.findById(categoryId);
        if (category.isPresent()) {
            return category.get();
        }
        throw  new ActionErrors("Category not found");

    }

    /**
     * @return
     */
    @Override
    public List<Category> getAllCategories() {
        return  categoryRepository.findAll();
    }
}
