package dev.eder.mvpwithdagger.ui.profile;

import androidx.appcompat.app.AppCompatActivity;
import dev.eder.mvpwithdagger.KataApplicattion;
import dev.eder.mvpwithdagger.R;
import dev.eder.mvpwithdagger.model.User;
import dev.eder.mvpwithdagger.ui.login.LoginActivity;
import dev.eder.mvpwithdagger.ui.ws.WsActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import javax.inject.Inject;

public class ProfileActivity extends AppCompatActivity implements Profile.ProfileView{

    TextInputEditText mEtName;

    TextInputEditText mEtAge;

    TextView mTvLogOut;

    TextView mTvWelcome;

    @Inject
    Profile.ProfilePresenter profilePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ((KataApplicattion)getApplication()).getAppComponent().inject(this);
        setUpViews();
    }

    private void setUpViews() {
         mEtName = findViewById(R.id.mEtName);
         mEtAge = findViewById(R.id.mEtAge);
         mTvLogOut = findViewById(R.id.mTvLogOut);
         mTvWelcome = findViewById(R.id.mTvProfile);
        profilePresenter.setUpView(this);
    }

    public void update(View view){
        profilePresenter.updateUser(new User(mEtName.getText().toString(),mEtAge.getText().toString()));
    }


    public void logOutClick(View view){
        profilePresenter.logOut();
    }

    public void goToNextActivity(View view){
        startActivity(new Intent(this, WsActivity.class));
    }

    @Override
    public void showUser(User user) {
        mEtAge.setText(user.age);
        mEtName.setText(user.userName);
    }

    @Override
    public void logOut() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
