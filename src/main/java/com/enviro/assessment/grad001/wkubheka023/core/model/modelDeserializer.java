package com.enviro.assessment.grad001.wkubheka023.core.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;


public class modelDeserializer {
    // to test the response.

    public static List<Waste> deserialize(String json) throws JsonProcessingException {
        return     new ObjectMapper().readValue(json, new TypeReference<List<Waste>>() {});
    }
}
