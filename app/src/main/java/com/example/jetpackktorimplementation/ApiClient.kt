package com.example.jetpackktorimplementation


import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.get

object ApiClient {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com"

    private val httpClient=HttpClient{
      install(JsonFeature)
    }

    suspend fun getPost():List<Feed>{
        return httpClient.get<List<Feed>>("$BASE_URL/posts")
    }
}