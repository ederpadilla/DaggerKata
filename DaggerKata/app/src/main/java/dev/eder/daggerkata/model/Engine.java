package dev.eder.daggerkata.model;

public class Engine {
    private String engineKind;


    public Engine(String engineKind){
        this.engineKind = engineKind;
    }

    public String getEngineKind(){
        return ("Motor: " + engineKind);
    }

}
