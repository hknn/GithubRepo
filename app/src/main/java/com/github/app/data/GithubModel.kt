package com.github.app.data

data class Github(
    val id: Int,
    val node_id: String,
    val name: String,
    val full_name: String,
    val owner: Owner,
    val stargazers_count: Int,
    val open_issues: Int
)

data class Owner(
    val id: Int,
    val login: String,
    val avatar_url: String,
    val url: String
)