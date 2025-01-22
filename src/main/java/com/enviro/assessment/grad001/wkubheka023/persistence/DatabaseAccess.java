package com.enviro.assessment.grad001.wkubheka023.persistence;
import com.enviro.assessment.grad001.wkubheka023.core.model.Category;
import com.enviro.assessment.grad001.wkubheka023.core.model.Waste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface DatabaseAccess extends JpaRepository<Waste, Integer> {
    public List<Waste> getWasteByCategory(Category category);

}