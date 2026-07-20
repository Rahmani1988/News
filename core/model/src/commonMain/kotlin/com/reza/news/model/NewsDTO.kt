package com.reza.news.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewsDTO(
    val status: String,
    val totalResults: Int,
    val articles: List<ArticleDTO>
)

@Serializable
data class ArticleDTO(
    val source: ArticleSourceDTO,
    val author: String?,
    val title: String,
    val description: String?,
    val url: String,
    @SerialName("urlToImage")
    val imageUrl: String?,
    val publishedAt: String,
    val content: String?
)

@Serializable
data class ArticleSourceDTO(
    val id: String?,
    val name: String
)