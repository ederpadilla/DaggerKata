package dev.eder.mvpwithdagger.ui.ws;

import androidx.appcompat.app.AppCompatActivity;
import dev.eder.mvpwithdagger.KataApplicattion;
import dev.eder.mvpwithdagger.R;
import dev.eder.mvpwithdagger.model.User;
import dev.eder.mvpwithdagger.ui.profile.Profile;
import dev.eder.mvpwithdagger.ui.profile.ProfileActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

public class WsActivity extends AppCompatActivity implements WebService.WebServiceView {

    TextView mTvUserName;
    TextView mTvUserAge;

    @Inject
    WebService.WebServicePresenter webServicePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ws);
        ((KataApplicattion)getApplication()).getAppComponent().inject(this);
        setUpViews();
    }

    private void setUpViews() {
        mTvUserName = findViewById(R.id.mTvUserName);
        mTvUserAge = findViewById(R.id.mTvAge);
        webServicePresenter.setUpView(this);
    }

    public void goBackToProfile(View view) {
        startActivity(new Intent(this, ProfileActivity.class));
    }

    public void wsRequest(View view) {
        webServicePresenter.wsRequest();
    }


    @Override
    public void showUser(User user) {
        mTvUserName.setText(user.userName);
        mTvUserAge.setText(user.age);
    }
}
