package dev.eder.mvpwithdagger.di;

import android.app.Application;
import android.content.Context;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dev.eder.mvpwithdagger.api.ApiClient;
import dev.eder.mvpwithdagger.model.User;
import dev.eder.mvpwithdagger.ui.login.LogIn;
import dev.eder.mvpwithdagger.ui.login.LoginPresenter;
import dev.eder.mvpwithdagger.ui.profile.Profile;
import dev.eder.mvpwithdagger.ui.profile.ProfilePresenter;
import dev.eder.mvpwithdagger.ui.ws.WSPresenter;
import dev.eder.mvpwithdagger.ui.ws.WebService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Application provideApplication(){
        return application;
    }

    @Provides
    @Singleton
    public Context provideApplicationContext(){
        return application;
    }

    @Provides
    @Singleton
    public User getUser(){
        return new User();
    }

    /*
    * Retrofit*/
    private static final String BASE_URL = "https://api.github.com/";

    @Singleton
    @Provides
    GsonConverterFactory providesGsonConverterFactory(){
        return GsonConverterFactory.create();
    }

    @Singleton
    @Provides
    OkHttpClient providesOkHttpClient(){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(20 , TimeUnit.SECONDS)
                .build();
    }

    @Singleton
    @Provides
    Retrofit providesRetrofit(GsonConverterFactory gsonConverterFactory, OkHttpClient okHttpClient){
        return new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(gsonConverterFactory)
                .client(okHttpClient)
                .build();
    }

    @Singleton
    @Provides
    ApiClient providesApiClient(Retrofit retrofit){
        return retrofit.create(ApiClient.class);
    }

    /*Grafo Activities**/

    @Provides
    @Singleton
    LogIn.Presenter providesPresenterLogin(User user){
        return new LoginPresenter(user);
    }

    @Provides
    @Singleton
    Profile.ProfilePresenter providesProfilePresenter(User user){
        return new ProfilePresenter(user);
    }

    @Provides
    @Singleton
    WebService.WebServicePresenter providesWebServicePresenter(User user,ApiClient apiClient){
        return new WSPresenter(user,apiClient);
    }

}
