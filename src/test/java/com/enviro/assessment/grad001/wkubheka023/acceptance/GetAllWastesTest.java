package com.enviro.assessment.grad001.wkubheka023.acceptance;

import com.enviro.assessment.grad001.wkubheka023.core.model.Category;
import com.enviro.assessment.grad001.wkubheka023.core.model.Waste;
import com.enviro.assessment.grad001.wkubheka023.core.model.modelDeserializer;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;


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

    @Test

    void deleteWaste(){

        String wasteJson = "{\n" +
                "    \"id\": 1,\n" +
                "    \"category\": \"plastic\",\n" +
                "    \"description\": \"Plastic bottle\",\n" +
                "    \"disposalGuidelines\": [\"Throw the plastic bottle in the designated plastic recycling bin\"],\n" +
                "    \"recyclingTips\": [\"Rinse out plastic bottles before recycling to remove contaminants\"]\n" +
                "}\n";

        HttpResponse<String> response = Unirest.delete(BASEURL + "remove").body(wasteJson).asString();
        assertEquals(200, response.getStatus());


    }

    @Test
    void addWaste() {
        String wasteJson = "{\n" +
                "    \"id\": 10,\n" +
                "    \"category\": \"plastic\",\n" +
                "    \"description\": \"Plastic bottle\",\n" +
                "    \"disposalGuidelines\": [\"Throw the plastic bottle in the designated plastic recycling bin\"],\n" +
                "    \"recyclingTips\": [\"Rinse out plastic bottles before recycling to remove contaminants\"]\n" +
                "}\n";


        HttpResponse<String> response = Unirest.post("add").body(wasteJson).asString();
        HttpResponse<String> response1 = Unirest.get(BASEURL + "wastes/10").asString();
        assertEquals(200, response1.getStatus());
        assertEquals(wasteJson, response1.getBody());

        System.out.println(response.getBody());
//        if (response.getStatus() == HttpStatus.CREATED) {
//
//
//        }
    }
}
