package com.reza.news.network

import com.reza.news.model.NewsDTO
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class ApiService(private val client: HttpClient) {
    suspend fun getTopHeadlines(country: String = "us"): NewsDTO {
        return client.get("top-headlines") {
            parameter("country", country)
        }.body()
    }
}