package dev.eder.daggerkata;

import android.app.Application;
import dev.eder.daggerkata.di.*;

public class BaseApp extends Application {

    private EngineComponent engineComponent;

    private CarComponent carComponent;

    private CarSubComponent carSubComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        engineComponent = DaggerEngineComponent
                .builder()
                .build();

        carComponent = DaggerCarComponent
                .builder()
                .engineComponent(getEngineComponent())
                .build();
    }

    public CarSubComponent plusCarSubComponent(){
        if (carSubComponent==null){
            carSubComponent = getEngineComponent().plusCarSubComponent(new CarModule());
        }
        return carSubComponent;
    }

    public EngineComponent getEngineComponent() {
        return engineComponent;
    }

    public CarComponent getCarComponent() {
        return carComponent;
    }
}
