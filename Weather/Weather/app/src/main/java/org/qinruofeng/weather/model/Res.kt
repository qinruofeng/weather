package org.qinruofeng.weather.model

data class Res(
    val count: Int,
    val info: String,
    val infocode: Int,
    val status: Int,
    val forecasts:List<City>
)