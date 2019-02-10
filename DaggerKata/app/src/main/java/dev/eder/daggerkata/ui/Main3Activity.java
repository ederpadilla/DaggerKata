package dev.eder.daggerkata.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import dev.eder.daggerkata.BaseApp;
import dev.eder.daggerkata.R;
import dev.eder.daggerkata.model.Car;
import dev.eder.daggerkata.model.Engine;
import dev.eder.daggerkata.util.CarsEnginesNamesKeys;

import javax.inject.Inject;
import javax.inject.Named;

import static dev.eder.daggerkata.util.CarsEnginesNamesKeys.DIESEL_CAR;
import static dev.eder.daggerkata.util.CarsEnginesNamesKeys.ELECTRIC_CAR;
import static dev.eder.daggerkata.util.CarsEnginesNamesKeys.GAS_CAR;

public class Main3Activity extends AppCompatActivity {

    TextView mTvSubComponentSample;

    @Named(ELECTRIC_CAR)
    @Inject
    Car gasCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ((BaseApp)getApplication()).plusCarSubComponent().inject(this);
        mTvSubComponentSample = findViewById(R.id.mTvSubComponentSample);
        mTvSubComponentSample.setText(gasCar.getCoche());
    }
}
