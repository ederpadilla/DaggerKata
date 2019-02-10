package dev.eder.dagger2kata.model;

public class Car {

    private Engine engine;

/*    public Car() {
        engine = new Engine("Electric");
    }*/

    public String getCar() {
        return "Car with "+engine.engineKind;
    }

    public Car(Engine engine) {
        this.engine = engine;
    }
}
