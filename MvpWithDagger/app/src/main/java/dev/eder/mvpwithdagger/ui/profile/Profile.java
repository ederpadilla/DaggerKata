package dev.eder.mvpwithdagger.ui.profile;

import dev.eder.mvpwithdagger.model.User;

public interface Profile {

    interface ProfileView{
        void showUser(User user);
        void logOut();
    }

    interface ProfilePresenter{

        void setUpView(ProfileView view);

        void updateUser(User updateUser);

        void logOut();
    }

}
