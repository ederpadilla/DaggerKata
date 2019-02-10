package dev.eder.mvpwithdagger.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import dev.eder.mvpwithdagger.KataApplicattion;
import dev.eder.mvpwithdagger.R;
import dev.eder.mvpwithdagger.ui.profile.ProfileActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity implements LogIn.View{

    private EditText mEtUser;

    private EditText mEtPass;

    @Inject
    LogIn.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ((KataApplicattion)getApplication()).getAppComponent().inject(this);
        setUpViews();
    }

    private void setUpViews() {
        presenter.setView(this);
        mEtUser = findViewById(R.id.etUser);
        mEtPass = findViewById(R.id.etPassword);
    }

    public void loginClick(View view){
        presenter.validUserPresenter(mEtUser.getText().toString(),mEtPass.getText().toString());
    }

    @Override
    public void validUser() {
        startActivity(new Intent(this, ProfileActivity.class));
    }

    @Override
    public void invaliduser() {
        Toast.makeText(this,getString(R.string.invalid_user),Toast.LENGTH_SHORT).show();
    }

}
