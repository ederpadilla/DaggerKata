package dev.eder.daggerkata.di;

import dagger.Subcomponent;
import dev.eder.daggerkata.ui.Main3Activity;

@Subcomponent(modules = CarModule.class)
public interface CarSubComponent {

    void inject(Main3Activity main3Activity);

}
