package com.enviro.assessment.grad001.wkubheka023.dao;
import com.enviro.assessment.grad001.wkubheka023.service.model.Waste;

import java.util.List;

public interface DatabaseAccess{
    void save(Waste waste);
    void update(Waste waste);
    void delete(Waste waste);
    List<Waste> findAll();
}