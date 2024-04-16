package com.example.wallstreetsentiment.stocks.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class StocksService(private val httpClient: HttpClient) {
    suspend fun fetchStocks(): StocksRaw {
        return httpClient.get("https://tradestie.com/api/v1/apps/reddit").body()
    }
}

//https://tradestie.com/api/v1/apps/reddit?date=2022-04-03