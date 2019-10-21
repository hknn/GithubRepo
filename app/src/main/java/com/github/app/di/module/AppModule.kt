package com.atech.daggerexample.di.module

import android.app.Application
import android.content.Context
import com.github.app.BaseApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun providesApplication(application: BaseApplication): Application = application

    @Provides
    @Singleton
    fun providesApplicationContext(application: BaseApplication): Context = application

}