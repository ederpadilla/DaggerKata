package dev.eder.mvpwithdagger;

import android.app.Application;

import dev.eder.mvpwithdagger.di.AppComponent;
import dev.eder.mvpwithdagger.di.AppModule;
import dev.eder.mvpwithdagger.di.DaggerAppComponent;

public class KataApplicattion extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        setupGraph();
    }

    private void setupGraph() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
