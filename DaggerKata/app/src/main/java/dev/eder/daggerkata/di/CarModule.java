package dev.eder.daggerkata.di;

import dagger.Module;
import dagger.Provides;
import dev.eder.daggerkata.model.Car;
import dev.eder.daggerkata.model.Engine;

import javax.inject.Named;

import static dev.eder.daggerkata.util.CarsEnginesNamesKeys.*;

@Module
public class CarModule {

    @Provides
    public Car getCar(Engine engine){
        return new Car(engine);
    }

    @Named(ELECTRIC_CAR)
    @Provides
    public Car getCarElectric(@Named(ELECTRIC) Engine engine){
        return new Car(engine);
    }

    @Named(DIESEL_CAR)
    @Provides
    public Car getCarDiesel(@Named(DIESEL) Engine engine){
        return new Car(engine);
    }
}
