package dev.eder.mvpwithdagger.api;

import dev.eder.mvpwithdagger.model.WsModelResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import static dev.eder.mvpwithdagger.api.ApiKeys.USER;
import static dev.eder.mvpwithdagger.api.EndPoints.REPOS;

public interface ApiClient {

    @GET(REPOS)
    Call<WsModelResponse> getReposFromUser(@Path(USER) String user);



}
