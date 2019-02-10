package dev.eder.dagger2kata.di;

import android.app.Application;

public class BaseApplication extends Application {

    private EngineComponent engineComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        engineComponent = DaggerEngineComponent
                .builder()
                .build();
    }

    public EngineComponent getEngineComponent() {
        return engineComponent;
    }
}
