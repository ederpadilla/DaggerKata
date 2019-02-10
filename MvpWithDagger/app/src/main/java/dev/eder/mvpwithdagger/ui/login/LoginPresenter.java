package dev.eder.mvpwithdagger.ui.login;

import dev.eder.mvpwithdagger.model.User;

public class LoginPresenter implements LogIn.Presenter{

    private LogIn.View view;

    private User user;

    public LoginPresenter(User user) {
        this.user = user;
    }
    @Override
    public void setView(LogIn.View view) {
        this.view = view;
    }

    @Override
    public void validUserPresenter(String userName, String password) {
        if (view!=null){
            if (userName.equals("Eder")&&password.equals("1234")){
                user.userName = "Eder Padilla";
                user.age = "25";
                view.validUser();
            }else{
                view.invaliduser();
            }
        }
    }



}
