package com.enviro.assessment.grad001.wkubheka023.dao;
import com.enviro.assessment.grad001.wkubheka023.core.model.Waste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DatabaseAccess extends JpaRepository<Waste, Integer> {

}