package com.enviro.assessment.grad001.wkubheka023.service;

import com.enviro.assessment.grad001.wkubheka023.service.model.Waste;

import java.util.List;

public interface WasteActions {
    public Waste addWaste(Waste waste);
    public Waste updateWaste(Waste waste);
    public Waste deleteWaste(Waste waste);
    public Waste getWaste(int id);
    public List<Waste> getAllWastes();
}
