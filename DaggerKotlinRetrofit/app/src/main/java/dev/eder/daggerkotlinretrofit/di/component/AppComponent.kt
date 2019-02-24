package dev.eder.daggerkotlinretrofit.di.component

import android.content.Context
import dagger.Component
import dev.eder.daggerkotlinretrofit.di.modules.AppModule
import dev.eder.daggerkotlinretrofit.ui.MainActivity
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun context(): Context

    fun inject(mainActivity: MainActivity)

}