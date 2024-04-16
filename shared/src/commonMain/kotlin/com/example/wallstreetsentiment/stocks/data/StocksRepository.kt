package com.example.wallstreetsentiment.stocks.data

class StocksRepository(
    private val service: StocksService
) {

    suspend fun getStocks(): StocksRaw {
        return service.fetchStocks()
    }
}