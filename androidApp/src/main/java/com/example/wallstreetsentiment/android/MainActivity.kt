package com.example.wallstreetsentiment.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.wallstreetsentiment.stocks.application.Stock
import com.example.wallstreetsentiment.stocks.application.Stocks
import com.example.wallstreetsentiment.stocks.presentation.StocksViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshState
import org.koin.androidx.compose.getViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DefaultPreview()
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String, stocksViewModel: StocksViewModel = getViewModel()) {
    val stocksState = stocksViewModel.stocksState.collectAsState()

    if (stocksState.value.error != null)
        ErrorMessage("Something went wrong")
    if (stocksState.value.stocks.isNotEmpty()) {
        StocksListView(stocksViewModel)
    }

}

@Composable
fun StocksListView(viewModel: StocksViewModel) {

    SwipeRefresh(
        state = SwipeRefreshState(viewModel.stocksState.value.loading),
        onRefresh = { viewModel.getStocks() }) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(viewModel.stocksState.value.stocks) { stock ->
                ArticleItemView(stock = stock)
            }
        }
    }
}

@Composable
fun ArticleItemView(stock: Stock) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(4.dp))
        Column {
            Text(text = stock.ticker, fontWeight = FontWeight.Bold,
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 22.sp))
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = stock.sentiment.value)
        }
                Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "${stock.sentimentScore}",
            color = if (stock.sentimentScore >= 0) Color.Green else Color.Red
        )
                Spacer(modifier = Modifier.height(4.dp))
    }
}
@Composable
fun ErrorMessage(message: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = message,
            style = TextStyle(fontSize = 28.sp, textAlign = TextAlign.Center)
        )
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}
