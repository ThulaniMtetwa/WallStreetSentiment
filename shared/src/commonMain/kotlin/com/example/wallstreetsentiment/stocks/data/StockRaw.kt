package com.example.wallstreetsentiment.stocks.data
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

typealias StocksRaw = List<StockRaw>

@Serializable
data class StockRaw (
    @SerialName("no_of_comments")
    val noOfComments: Long,

    val sentiment: Sentiment,

    @SerialName("sentiment_score")
    val sentimentScore: Double,

    val ticker: String
)

@Serializable
enum class Sentiment(val value: String) {
    @SerialName("Bearish") Bearish("Bearish"),
    @SerialName("Bullish") Bullish("Bullish");
}