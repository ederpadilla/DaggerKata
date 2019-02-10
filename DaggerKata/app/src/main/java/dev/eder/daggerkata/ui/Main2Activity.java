package dev.eder.daggerkata.ui;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import dev.eder.daggerkata.BaseApp;
import dev.eder.daggerkata.R;
import dev.eder.daggerkata.model.Engine;

import javax.inject.Inject;
import javax.inject.Named;

public class Main2Activity extends AppCompatActivity {


    @Named("Electric")
    @Inject
    Engine engine;
    private String TAG = Main2Activity.class.getSimpleName();

    private TextView mTvEngineKind;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mTvEngineKind = findViewById(R.id.mTvEngineKind);
        ((BaseApp)getApplication()).getEngineComponent().inject(this);

        mTvEngineKind.setText("this is the engine kind dude 👉🏻" +engine.getEngineKind() );

    }
}
