package com.enviro.assessment.grad001.wkubheka023.controller;

import com.enviro.assessment.grad001.wkubheka023.core.errors.ActionErrors;
import com.enviro.assessment.grad001.wkubheka023.core.model.Waste;
import com.enviro.assessment.grad001.wkubheka023.service.WasteActions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WasteController {
    @Autowired
    private WasteActions waterActionsImp;
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(path = "/wastes")
    public List<Waste> getWastes() {
        return waterActionsImp.getAllWastes();
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(path = "/search/{categoryString}")
    public List<Waste> getWastesByCategory(@PathVariable String categoryString) throws ActionErrors {
        return waterActionsImp.getWastesByCategory(categoryString);
    }
    @ResponseStatus(code = HttpStatus.OK)

    @GetMapping(path="/wastes/{id}")
    public Waste getWasteById(@PathVariable int id) {
        try{
            return waterActionsImp.getWaste(id);

        }catch (Exception e){
            return new Waste();
        }
    }
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "/add")
    public Waste addWaste(@RequestBody Waste waste) throws ActionErrors {
        return waterActionsImp.addWaste(waste);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @PutMapping(path = "/update")
    public Waste updateWaste(@RequestBody Waste waste) {
        return waterActionsImp.updateWaste(waste);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping(path = "/remove")
    public Waste deleteWaste(@RequestBody Waste waste) {
        try{
            return waterActionsImp.deleteWaste(waste);

        }catch (Exception e){
            return null;
        }
    }

//    public List<Waste> getWastes_() {
//
//
//
//        List<Waste> wastes =  waterActionsImp.getAllWastes();
//        List<String> wasteList = new ArrayList<String>();
//        for (Waste waste : wastes) {
//            wasteList.add(waste.));
//
//        }
//    }




}
