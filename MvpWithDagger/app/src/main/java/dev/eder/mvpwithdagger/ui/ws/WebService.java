package dev.eder.mvpwithdagger.ui.ws;

import dev.eder.mvpwithdagger.model.User;

public interface WebService {

    interface WebServiceView{
        void showUser(User user);
    }

    interface WebServicePresenter{
        void setUpView(WebServiceView view);
        void wsRequest();
    }


}
