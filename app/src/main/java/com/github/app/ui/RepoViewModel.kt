package com.github.app.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.app.data.Github
import com.github.app.data.GithubService
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Inject

private val executor: Executor = Executors.newSingleThreadExecutor()

class RepoViewModel @Inject constructor(private val service: GithubService) : ViewModel() {

    val repos = MutableLiveData<List<Github>>()

    fun getRepos(username: String) {
        executor.execute {
            val response = service.getRepos(username).execute()
            val items = response.body().orEmpty()
            repos.postValue(items)
        }
    }
}