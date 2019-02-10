package dev.eder.daggerkata.model;

public class Car {

    private Engine engine;

    public Car(Engine engine){
        this.engine = engine;
    }

    public String getCoche(){
        return ("Car with " + engine.getEngineKind());
    }

}
