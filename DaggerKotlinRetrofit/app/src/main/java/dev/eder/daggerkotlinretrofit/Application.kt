package dev.eder.daggerkotlinretrofit

import android.app.Application
import android.content.Context
import dev.eder.daggerkotlinretrofit.di.component.AppComponent
import dev.eder.daggerkotlinretrofit.di.component.DaggerAppComponent
import dev.eder.daggerkotlinretrofit.di.component.DaggerRetrofitComponent
import dev.eder.daggerkotlinretrofit.di.component.RetrofitComponent
import dev.eder.daggerkotlinretrofit.di.modules.AppModule
import dev.eder.daggerkotlinretrofit.di.modules.RetroditModule

class Application : Application() {

    lateinit var component : AppComponent

    lateinit var retrofitComponent: RetrofitComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
        retrofitComponent = DaggerRetrofitComponent
            .builder()
            .retroditModule(RetroditModule(this))
            .build()
    }

    companion object {
        lateinit var instance: Application private set
    }
}