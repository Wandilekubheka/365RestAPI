package com.enviro.assessment.grad001.wkubheka023.unittest;

import com.enviro.assessment.grad001.wkubheka023.persistence.DatabaseAccess;
import com.enviro.assessment.grad001.wkubheka023.service.WasteActions;
import com.enviro.assessment.grad001.wkubheka023.service.WaterActionsImp;
import org.junit.jupiter.api.BeforeAll;

public class wasteActionTest {
    private static WasteActions wasteActions;

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        DatabaseAccess databaseAccess = null;
        wasteActions = new WaterActionsImp(databaseAccess);
    }
}
