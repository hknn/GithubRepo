package com.github.app

import android.app.Application
import com.github.app.di.AppComponent
import com.github.app.di.DaggerAppComponent

import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject


class BaseApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        setAppComponent(DaggerAppComponent.builder().application(this).build())
        getAppComponent().inject(this)

    }

    override fun androidInjector() = androidInjector

    companion object {
        private lateinit var appComponent: AppComponent

        fun getAppComponent(): AppComponent {
            return appComponent
        }

        fun setAppComponent(component: AppComponent) {
            appComponent = component
        }
    }
}