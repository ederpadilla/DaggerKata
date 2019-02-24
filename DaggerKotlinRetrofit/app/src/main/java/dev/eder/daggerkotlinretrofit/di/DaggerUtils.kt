package dev.eder.daggerkotlinretrofit.di

import androidx.appcompat.app.AppCompatActivity
import dev.eder.daggerkotlinretrofit.Application
import dev.eder.daggerkotlinretrofit.di.component.AppComponent

//fun AppCompatActivity.component() : AppComponent = (application as Application).component

val AppCompatActivity.component : AppComponent
get() = (application as Application).component