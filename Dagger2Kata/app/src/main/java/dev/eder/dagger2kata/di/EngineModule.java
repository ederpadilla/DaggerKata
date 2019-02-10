package dev.eder.dagger2kata.di;

import dagger.Module;
import dagger.Provides;
import dev.eder.dagger2kata.model.Car;
import dev.eder.dagger2kata.model.Engine;

import javax.inject.Named;
import javax.inject.Singleton;

@Module //Provides or Activity all instances need for this class
public class EngineModule {

    @Singleton
    @Named("Electric")
    @Provides //To indicate what methods we has just created
    public Engine providesEngine(){
        return new Engine("Electric");
    }

    @Singleton
    @Named("Gas")
    @Provides
    public Engine providesGasEngine(){return new Engine("Gas");}

    @Provides
    public Car providesCar(@Named("Gas") Engine engine){ return new Car(engine);}

}
