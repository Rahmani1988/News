package com.reza.news.app.di

import com.reza.news.network.di.networkModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(
        networkModule,
    )
}

// Special helper JUST for iOS/Swift
fun initKoinIos() = initKoin {}