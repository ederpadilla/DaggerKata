package dev.eder.dagger2kata;

import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import dagger.Lazy;
import dev.eder.dagger2kata.di.BaseApplication;
import dev.eder.dagger2kata.model.Car;
import dev.eder.dagger2kata.model.Engine;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

public class MainCarActivity extends AppCompatActivity {


    private String TAG = MainCarActivity.class.getSimpleName();

    @Inject
    @Named("Electric")
    Engine engineWithDI;

    @Inject
    Car car;

    @Inject
    Lazy<Car> carLazy;

    @Inject
    Provider<Car> carProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_main);
        ((BaseApplication)getApplication()).getEngineComponent().inject(this);

        Log.e(TAG, "onCreate: tipe DI "+engineWithDI.engineKind);

        Log.e(TAG, "onCreate: Car DI "+ car.getCar());

        Log.e(TAG, "onCreate: Car Lazy "+ carLazy.get().getCar());

        Log.e(TAG, "onCreate: Car Provider "+ carProvider.get().getCar());

    }
}
