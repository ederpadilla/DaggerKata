package dev.eder.mvpwithdagger.ui.profile;

import dev.eder.mvpwithdagger.model.User;

public class ProfilePresenter implements Profile.ProfilePresenter{

    User user;

    Profile.ProfileView profileView;

    public ProfilePresenter(User user) {
        this.user = user;
    }

    @Override
    public void setUpView(Profile.ProfileView view) {
        this.profileView = view;
        profileView.showUser(user);
    }

    @Override
    public void updateUser(User updateUser) {
        if (updateUser.age!=null&&updateUser.userName!=null) {
            user.userName = updateUser.userName;
            user.age = updateUser.age;
        }
    }

    @Override
    public void logOut() {
        user.userName = null;
        user.age = null;
        profileView.logOut();
    }
}
