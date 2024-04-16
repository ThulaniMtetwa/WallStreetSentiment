package com.example.wallstreetsentiment.di

import com.example.wallstreetsentiment.stocks.di.stocksModule

val sharedKoinModules = listOf(
    stocksModule,
    networkModule,
)