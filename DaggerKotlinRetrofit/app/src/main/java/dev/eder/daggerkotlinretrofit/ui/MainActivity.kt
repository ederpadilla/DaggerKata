package dev.eder.daggerkotlinretrofit.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import dev.eder.daggerkotlinretrofit.Application
import dev.eder.daggerkotlinretrofit.R
import dev.eder.daggerkotlinretrofit.di.component
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var customContext : Context



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        component.inject(this)
        Toast.makeText(customContext,"asdasd",Toast.LENGTH_SHORT).show()
    }
}
