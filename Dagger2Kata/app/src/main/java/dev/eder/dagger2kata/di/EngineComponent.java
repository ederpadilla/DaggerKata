package dev.eder.dagger2kata.di;

import dagger.Component;
import dev.eder.dagger2kata.MainCarActivity;

import javax.inject.Singleton;

@PerActivity
@Singleton
@Component(modules = EngineModule.class) //The bridge between modules created and the classes
                                        // that requires the objects for the di
public interface EngineComponent {

    void inject(MainCarActivity mainActivity);//Where we want to inject our module

}
