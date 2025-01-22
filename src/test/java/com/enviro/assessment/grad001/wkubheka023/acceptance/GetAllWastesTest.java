package com.enviro.assessment.grad001.wkubheka023.acceptance;

import com.enviro.assessment.grad001.wkubheka023.core.model.Category;
import com.enviro.assessment.grad001.wkubheka023.core.model.Waste;
import com.enviro.assessment.grad001.wkubheka023.core.model.modelDeserializer;
import kong.unirest.Body;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;


public class GetAllWastesTest {
    private final String BASEURL = "http://localhost:8080/";
    @Test
    void getAllWastes() {
        HttpResponse<String> response = Unirest.get(BASEURL + "wastes").asString();
        if (response.getStatus() == 200) {
            try{
            List<Waste> wastes = modelDeserializer.deserialize(response.getBody());
            assertFalse(wastes.isEmpty());
        }catch (Exception e){
            // case it fails to deserialize
            assertEquals(1,3);
        }
        }
    }
    @Test
    void getAllWastesByCategory() {
        HttpResponse<String> response = Unirest.get(BASEURL + "search/metal").asString();
        if (response.getStatus() == 200) {
            try{
                List<Waste> wastes = modelDeserializer.deserialize(response.getBody());
                assertFalse(wastes.isEmpty());
                assertTrue(wastes.stream().allMatch(w -> w.getCategory() == Category.metal));

            }catch (Exception e){
                assertEquals(1,3);
            }
        }
        HttpResponse<String> response1 = Unirest.get(BASEURL + "search/plastic").asString();
        if (response1.getStatus() == 200) {
            try{
                List<Waste> wastes = modelDeserializer.deserialize(response1.getBody());
                assertFalse(wastes.isEmpty());
                assertTrue(wastes.stream().allMatch(w -> w.getCategory() == Category.plastic));

            }catch (Exception e){
                assertEquals(1,3);
            }
        }
    }
}
