package com.example.wallstreetsentiment.android

import com.example.wallstreetsentiment.stocks.presentation.StocksViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {

    viewModel { StocksViewModel(get()) }
}