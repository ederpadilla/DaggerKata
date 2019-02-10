package dev.eder.daggerkata.di;

import dagger.Component;
import dev.eder.daggerkata.ui.MainActivity;

@Component(modules = CarModule.class,dependencies = EngineComponent.class)
public interface CarComponent {

    void inject(MainActivity mainActivity);

}
