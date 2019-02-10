package dev.eder.daggerkata.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import dev.eder.daggerkata.BaseApp;
import dev.eder.daggerkata.R;
import dev.eder.daggerkata.di.CarComponent;
import dev.eder.daggerkata.model.Car;
import dev.eder.daggerkata.util.CarsEnginesNamesKeys;

import javax.inject.Inject;
import javax.inject.Named;

import static dev.eder.daggerkata.util.CarsEnginesNamesKeys.DIESEL_CAR;
import static dev.eder.daggerkata.util.CarsEnginesNamesKeys.ELECTRIC_CAR;

public class MainActivity extends AppCompatActivity {

    Button mBuSubComponent;

    Button mBu;

    TextView mTvCar;

    @Inject
    Car gasCar;

    @Named(ELECTRIC_CAR)
    @Inject
    Car electricCar;

    @Named(DIESEL_CAR)
    @Inject
    Car dieselCar;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((BaseApp)getApplication()).getCarComponent().inject(this);
        setUpViews();

        mTvCar.setText("Rebeld Thunder is 🚘"+ gasCar.getCoche()+"\n"+
                        "His brother is 🚗"+electricCar.getCoche()+"\n"+
                        "His sister is 🚗"+dieselCar.getCoche());

    }

    private void setUpViews() {
        mBuSubComponent = findViewById(R.id.button3);
        mBu = findViewById(R.id.button4);
        mTvCar = findViewById(R.id.mTvCar);
    }

    public void goToMain2(View view){
        startActivity(new Intent(this,Main2Activity.class));
    }

    public void goToMain3(View view){
        startActivity(new Intent(this,Main3Activity.class));
    }

}
