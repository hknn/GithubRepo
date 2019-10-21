package com.github.app.data

import com.github.app.BuildConfig
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubService {

    @GET("users/{username}/repos")
    fun getRepos(
        @Path("username") username: String,
        @Query("client_id") clientId: String = BuildConfig.GithubClientId,
        @Query("client_secret") clientSecret: String = BuildConfig.GithubClientSecret
    ): Call<List<Github>>
}