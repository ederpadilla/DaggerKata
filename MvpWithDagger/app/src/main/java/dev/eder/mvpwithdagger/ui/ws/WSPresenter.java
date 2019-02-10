package dev.eder.mvpwithdagger.ui.ws;


import android.util.Log;

import dev.eder.mvpwithdagger.api.ApiClient;
import dev.eder.mvpwithdagger.model.User;
import dev.eder.mvpwithdagger.model.WsModelResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WSPresenter implements WebService.WebServicePresenter{

    private User user;

    private WebService.WebServiceView webServiceView;

    private ApiClient apiClient;


    public WSPresenter(User user, ApiClient apiClient) {
        this.user = user;
        this.apiClient = apiClient;
    }

    @Override
    public void setUpView(WebService.WebServiceView view) {
        this.webServiceView = view;
        webServiceView.showUser(user);
    }

    @Override
    public void wsRequest() {
        Call<WsModelResponse> call = apiClient.getReposFromUser(user.userName);
        call.enqueue(new Callback<WsModelResponse>() {
            @Override
            public void onResponse(Call<WsModelResponse> call, Response<WsModelResponse> response) {
                Log.e("Reponse", "onResponse: " +response.body());
            }

            @Override
            public void onFailure(Call<WsModelResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

}
