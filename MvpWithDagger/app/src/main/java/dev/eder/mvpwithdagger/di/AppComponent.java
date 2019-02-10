package dev.eder.mvpwithdagger.di;

import javax.inject.Singleton;

import dagger.Component;
import dev.eder.mvpwithdagger.ui.login.LoginActivity;
import dev.eder.mvpwithdagger.ui.profile.ProfileActivity;
import dev.eder.mvpwithdagger.ui.ws.WsActivity;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    void inject(LoginActivity loginActivity);

    void inject(ProfileActivity profileActivity);

    void inject(WsActivity wsActivity);

}
