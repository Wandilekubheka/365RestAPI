package com.enviro.assessment.grad001.wkubheka023.service.waste;

import com.enviro.assessment.grad001.wkubheka023.core.errors.ActionErrors;
import com.enviro.assessment.grad001.wkubheka023.core.model.Waste;
import com.enviro.assessment.grad001.wkubheka023.persistence.DatabaseAccess;
import org.springframework.stereotype.Component;

import java.util.List;



@Component
public class WasteActionsImp implements   WasteActions {

    private final DatabaseAccess databaseAccess;
    public WasteActionsImp(DatabaseAccess databaseAccess) {
        this.databaseAccess = databaseAccess;
    }

    /***
     * method for adding waste to database
     ***/

    @Override
    public Waste addWaste(Waste waste) throws ActionErrors {
        List<Waste> wastes = getAllWastes();
        if (!wastes.contains(waste)) {
            return databaseAccess.save(waste);
        }
        throw  new ActionErrors("Add waste failed, waste already exists");

    }

    /***
     * method for updating waste to database
     ***/
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



    /***
     * fetch data from database using its id
     ***/
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



    /***
     * fetch all data from database
     ***/
    @Override
    public List<Waste> getAllWastes() {
        return databaseAccess.findAll();
    }




    /***
     * fetch data by category
     ***/
    @Override
    public List<Waste> getWastesByCategory(String category) throws ActionErrors {
        try{
            // attempting to convert to enum in order to check if @param category is valid category
            return databaseAccess.getWasteByCategory(category.toUpperCase());
        }catch (IllegalArgumentException e){
            // custom error handling
            throw new ActionErrors("category not found");
        }
    }
}
