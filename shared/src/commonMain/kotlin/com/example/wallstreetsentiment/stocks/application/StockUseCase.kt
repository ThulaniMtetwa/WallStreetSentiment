package com.example.wallstreetsentiment.stocks.application

import com.example.wallstreetsentiment.stocks.data.StocksRaw
import com.example.wallstreetsentiment.stocks.data.StocksRepository

class StockUseCase(private val repo: StocksRepository) {

    suspend fun getArticles(): Stocks {
        val stocksRaw = repo.getStocks()
        return mapStocks(stocksRaw)
    }

    private fun mapStocks(stocksRaw: StocksRaw): Stocks = stocksRaw.map { raw ->
        Stock(
            raw.noOfComments,
            raw.sentiment,
            raw.sentimentScore,
            raw.ticker
        )
    }
}