package com.example.wallstreetsentiment.stocks.di

import com.example.wallstreetsentiment.stocks.application.StockUseCase
import com.example.wallstreetsentiment.stocks.data.StocksRepository
import com.example.wallstreetsentiment.stocks.data.StocksService
import com.example.wallstreetsentiment.stocks.presentation.StocksViewModel
import org.koin.dsl.module

val stocksModule = module {
    single<StocksService> { StocksService(get()) }
    single<StockUseCase> { StockUseCase(get()) }
    single<StocksViewModel> { StocksViewModel(get()) }
    single<StocksRepository> { StocksRepository(get()) }
}