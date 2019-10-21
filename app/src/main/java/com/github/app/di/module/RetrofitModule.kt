package com.github.app.di.module


import com.github.app.data.GithubService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
abstract class RetrofitModule {

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideGithubService(): GithubService {
            return Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GithubService::class.java)
        }
    }

}