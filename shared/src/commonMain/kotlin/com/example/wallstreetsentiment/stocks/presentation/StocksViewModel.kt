package com.example.wallstreetsentiment.stocks.presentation

import com.example.wallstreetsentiment.BaseViewModel
import com.example.wallstreetsentiment.stocks.application.StockUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class StocksViewModel(
    private val useCase: StockUseCase
) : BaseViewModel() {

    private val _stocksState: MutableStateFlow<StocksState> =
        MutableStateFlow(StocksState(loading = true))

    val stocksState: StateFlow<StocksState> get() = _stocksState

    init {
        getStocks()
    }

    fun getStocks() {
        scope.launch {
            _stocksState.emit(StocksState(loading = true, stocks = _stocksState.value.stocks))

            val fetchedStocks = useCase.getArticles()

            _stocksState.emit(StocksState(stocks = fetchedStocks))
        }
    }
}