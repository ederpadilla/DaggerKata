package dev.eder.mvpwithdagger.ui.login;

public interface LogIn {

    public interface View {
        void validUser();
        void invaliduser();
    }

    public interface  Presenter {
        void validUserPresenter(String user, String password);
        void setView(LogIn.View view);
    }

}
