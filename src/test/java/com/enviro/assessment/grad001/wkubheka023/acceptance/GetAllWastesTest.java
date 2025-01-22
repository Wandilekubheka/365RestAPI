package com.enviro.assessment.grad001.wkubheka023.acceptance;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.junit.jupiter.api.Test;


public class GetAllWastesTest {
    private final String BASEURL = "http://localhost:8080/";
    @Test
    void getAllWastes() {
        HttpResponse<String> response = Unirest.get(BASEURL + "wastes").asString();
        System.out.println( response.getBody() );
    }
}
