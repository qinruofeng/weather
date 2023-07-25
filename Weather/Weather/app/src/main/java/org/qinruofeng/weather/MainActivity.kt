package org.qinruofeng.weather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import org.qinruofeng.weather.model.City
import org.qinruofeng.weather.model.Weather
import org.qinruofeng.weather.network.service
import org.qinruofeng.weather.ui.theme.WeatherTheme

class MainActivity : ComponentActivity() {
    private val cities = listOf("110000","310000","440100","440300","320500","210100")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LazyColumn() {
                        items(cities) { city ->
                            var state:City? by remember {
                                mutableStateOf(null)
                            }
                            LaunchedEffect(null) {
                                val weather = service.getWeather(city)
                                state = weather.forecasts[0]
                            }
                            Greeting(state)
                            Spacer(modifier = Modifier.height(8.dp))
                        }

                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: City?, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = "${name?.city ?: "城市"} 明天的天气",
            modifier = modifier
        )
        val weather = name?.casts?.get(1)
        Text(
            text = "白天: ${weather?.dayweather ?: "晴"}",
            modifier = modifier
        )
        Text(
            text = "白天温度: ${weather?.daytemp ?: "25"}度",
            modifier = modifier
        )
        Text(
            text = "白天风力: ${weather?.daypower ?: "3"}级",
            modifier = modifier
        )
        Text(
            text = "白天风向: ${weather?.daywind ?: "东"}",
            modifier = modifier
        )
        Text(
            text = "晚上: ${weather?.nightweather ?: "晴"}",
            modifier = modifier
        )
        Text(
            text = "白天温度: ${weather?.nighttemp ?: "25"}度",
            modifier = modifier
        )
        Text(
            text = "白天风力: ${weather?.nightpower ?: "3"}级",
            modifier = modifier
        )
        Text(
            text = "白天风向: ${weather?.nightwind ?: "东"}",
            modifier = modifier
        )
    }

}
