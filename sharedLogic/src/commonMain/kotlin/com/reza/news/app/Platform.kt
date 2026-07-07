package com.reza.news.app

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform