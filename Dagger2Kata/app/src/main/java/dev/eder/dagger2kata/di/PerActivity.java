package dev.eder.dagger2kata.di;

import javax.inject.Scope;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Scope //this will set the life of an instance inside a lifecycle
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {


}
