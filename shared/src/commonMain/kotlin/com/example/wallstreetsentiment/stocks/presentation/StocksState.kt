package com.example.wallstreetsentiment.stocks.presentation

import com.example.wallstreetsentiment.stocks.application.Stocks

data class StocksState (
    val stocks: Stocks = listOf(),
    val loading: Boolean = false,
    val error: String? = null
)
