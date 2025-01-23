package com.enviro.assessment.grad001.wkubheka023.controller;

import com.enviro.assessment.grad001.wkubheka023.core.errors.ActionErrors;
import com.enviro.assessment.grad001.wkubheka023.core.model.Waste;
import com.enviro.assessment.grad001.wkubheka023.service.waste.WasteActions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wastes")
public class WasteController {
    @Autowired
    private WasteActions waterActionsImp;
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(path = "")
    public List<Waste> getWastes() {
        return waterActionsImp.getAllWastes();
    }

    @GetMapping(path = "/search/{categoryString}")
    public List<Waste> getWastesByCategory(@PathVariable String categoryString) throws ActionErrors {
        return waterActionsImp.getWastesByCategory(categoryString);
    }

    @GetMapping(path="/{id}")
    public Waste getWasteById(@PathVariable int id) throws ActionErrors {
            return waterActionsImp.getWaste(id);

    }
    @PostMapping( )
    public Waste addWaste(@RequestBody Waste waste) throws ActionErrors {
        return waterActionsImp.addWaste(waste);
    }
    @PutMapping( )
    public Waste updateWaste(@RequestBody Waste waste) {
        return waterActionsImp.updateWaste(waste);
    }

    @DeleteMapping()
    public Waste deleteWaste(@RequestBody Waste waste) {
        try{
            return waterActionsImp.deleteWaste(waste);

        }catch (Exception e){
            return null;
        }
    }






}
