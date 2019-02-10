package dev.eder.daggerkata.di;


import dagger.Component;
import dev.eder.daggerkata.model.Engine;
import dev.eder.daggerkata.ui.Main2Activity;
import dev.eder.daggerkata.util.CarsEnginesNamesKeys;

import javax.inject.Named;

import static dev.eder.daggerkata.util.CarsEnginesNamesKeys.*;

@Component(modules = EngineModule.class)
public interface EngineComponent {

    Engine engine(); //methods that return objects that get used by dependents child classes

    @Named(ELECTRIC) Engine electricEngine();

    @Named(DIESEL) Engine dieselEngine();



    void inject(Main2Activity main2Activity); //This goes in activities, fragment services etc

    CarSubComponent plusCarSubComponent(CarModule carModule);

}
