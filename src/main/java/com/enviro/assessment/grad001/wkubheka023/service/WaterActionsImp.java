package com.enviro.assessment.grad001.wkubheka023.service;

import com.enviro.assessment.grad001.wkubheka023.core.errors.ActionErrors;
import com.enviro.assessment.grad001.wkubheka023.core.model.Category;
import com.enviro.assessment.grad001.wkubheka023.core.model.Waste;
import com.enviro.assessment.grad001.wkubheka023.dao.DatabaseAccess;
import org.springframework.stereotype.Component;

import java.util.List;



@Component
public class WaterActionsImp implements   WasteActions {

    private final DatabaseAccess databaseAccess;

    public WaterActionsImp(DatabaseAccess databaseAccess) {
        this.databaseAccess = databaseAccess;
    }


    @Override
    public Waste addWaste(Waste waste) {
        return databaseAccess.save(waste);
    }

    @Override
    public Waste updateWaste(Waste waste) {
        return databaseAccess.save(waste);
    }

    @Override
    public Waste deleteWaste(Waste waste) throws ActionErrors {
        Waste item = getWaste(waste.getId());
        if (item != null) {
            databaseAccess.delete(item);
            return waste;
        }
        throw new ActionErrors("item not found");
    }

    @Override
    public Waste getWaste(int id) throws ActionErrors {
        Waste itemFound = databaseAccess.findById(id).orElse(new Waste());
        // attempting to find waste product from db
        if(itemFound.getId() == id) {
            return itemFound;
        }else{
            throw new ActionErrors("item not found");
        }
    }

    @Override
    public List<Waste> getAllWastes() {
        return databaseAccess.findAll();
    }

    @Override
    public List<Waste> getWastesByName(String wasteName) throws ActionErrors {
        try{
            return databaseAccess.getWasteByName(wasteName);
        }catch (Exception e){
            throw new ActionErrors("category not found");
        }
    }

    @Override
    public List<Waste> getWastesByCategory(String category) throws ActionErrors {
        try{
            Category category1 = Category.valueOf(category);
            return databaseAccess.getWasteByCategory(category1);
        }catch (IllegalArgumentException e){
            throw new ActionErrors("category not found");
        }
    }
}
