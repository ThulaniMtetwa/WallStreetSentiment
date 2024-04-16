package com.example.wallstreetsentiment.stocks.application

import com.example.wallstreetsentiment.stocks.data.Sentiment

typealias Stocks = List<Stock>

data class Stock(
    val noOfComments: Long,
    val sentiment: Sentiment,
    val sentimentScore: Double,
    val ticker: String
)

enum class Sentiment {
    Bearish,
    Bullish
}
