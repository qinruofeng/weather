package org.qinruofeng.weather.model

data class City(
    val adcode: String,
    val city: String,
    val province: String,
    val reporttime: String,
    val casts:List<Weather>
)