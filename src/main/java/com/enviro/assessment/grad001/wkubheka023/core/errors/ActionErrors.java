package com.enviro.assessment.grad001.wkubheka023.core.errors;

public class ActionErrors extends Exception{
    String message;
    public ActionErrors(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

}
