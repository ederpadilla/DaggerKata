package dev.eder.daggerkotlinretrofit.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import dev.eder.daggerkotlinretrofit.Application
import javax.inject.Singleton

@Module
class AppModule(private val appication : Application) {

    @Provides //scope is not necessary for parameters stored within the module
    fun context(): Context {
        return appication.applicationContext
    }
}