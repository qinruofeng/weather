package org.qinruofeng.weather.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
var key: String = "02c8e8bcff399f3327fce072fb96b76c"

val client = OkHttpClient.Builder()
    .addInterceptor {
        val request = it.request()
        val url = request.url().newBuilder()
            .addQueryParameter("key", key)
            .addQueryParameter("extensions", "all")
            .build()
        it.proceed(request.newBuilder().url(url).build())
    }.build()
val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl("https://restapi.amap.com/")
    .client(client)
    .addConverterFactory(GsonConverterFactory.create(GsonBuilder()
        .setDateFormat("YYYY-MM-dd HH:mm:ss")
        .create()))
    .build()
val service: Service = retrofit.create(Service::class.java)