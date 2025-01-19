package com.enviro.assessment.grad001.wkubheka023.service;

import com.enviro.assessment.grad001.wkubheka023.core.errors.ActionErrors;
import com.enviro.assessment.grad001.wkubheka023.core.model.Waste;

import java.util.List;

public interface WasteActions {
    public Waste addWaste(Waste waste);
    public Waste updateWaste(Waste waste);
    public Waste deleteWaste(Waste waste) throws ActionErrors;
    public Waste getWaste(int id) throws ActionErrors;
    public List<Waste> getAllWastes();
}
