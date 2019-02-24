package dev.eder.daggerkotlinretrofit.di.component

import dagger.Component
import dev.eder.daggerkotlinretrofit.di.modules.RetroditModule
import gosmo.uble.anda.client.ApiServiceClient
import javax.inject.Singleton




@Singleton
@Component(modules = arrayOf(RetroditModule::class))
interface RetrofitComponent {

    fun apiService(): ApiServiceClient

}