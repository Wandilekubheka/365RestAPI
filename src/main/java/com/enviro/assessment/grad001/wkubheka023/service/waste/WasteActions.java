package com.enviro.assessment.grad001.wkubheka023.service.waste;

import com.enviro.assessment.grad001.wkubheka023.core.errors.ActionErrors;
import com.enviro.assessment.grad001.wkubheka023.core.model.Waste;

import java.util.List;

public interface WasteActions {
    public Waste addWaste(Waste waste) throws ActionErrors;
    public Waste updateWaste(Waste waste);
    public Waste deleteWaste(Waste waste) throws ActionErrors;
    public Waste getWaste(int id) throws ActionErrors;
    public List<Waste> getAllWastes();
    public List<Waste> getWastesByCategory(String category) throws ActionErrors;

}
