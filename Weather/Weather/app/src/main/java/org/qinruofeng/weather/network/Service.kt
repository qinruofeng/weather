package org.qinruofeng.weather.network

import org.qinruofeng.weather.model.Res
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {
    @GET("/v3/weather/weatherInfo")
    suspend fun getWeather(@Query("city") cityCode:String): Res

}
