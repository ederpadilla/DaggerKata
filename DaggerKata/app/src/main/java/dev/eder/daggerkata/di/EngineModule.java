package dev.eder.daggerkata.di;

import dagger.Module;
import dagger.Provides;
import dev.eder.daggerkata.model.Engine;

import javax.inject.Named;

import static dev.eder.daggerkata.util.CarsEnginesNamesKeys.DIESEL;
import static dev.eder.daggerkata.util.CarsEnginesNamesKeys.ELECTRIC;
import static dev.eder.daggerkata.util.CarsEnginesNamesKeys.GAS;

@Module //Provides or Activity all instances need for this class
public class EngineModule {

    @Provides //To indicate what methods we has just created
    public Engine providesEngineGas(){
        return new Engine(GAS);
    }

    @Named(ELECTRIC)
    @Provides //To indicate what methods we has just created
    public Engine providesEngineElectric(){
        return new Engine(ELECTRIC);
    }

    @Named(DIESEL)
    @Provides //To indicate what methods we has just created
    public Engine providesEngineDiesel(){
        return new Engine(DIESEL);
    }


}
