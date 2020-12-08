package com.project.bicycleraceanalysis.di

import com.project.bicycleraceanalysis.network.api.GameApi
import com.project.bicycleraceanalysis.network.api.PlayerApi
import okhttp3.OkHttpClient
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {

    val BASE_URL = "http://13.124.54.4:51875/"

    single<GameApi>{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(get(named("okHttp")))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GameApi::class.java)
    }

    single<PlayerApi>{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(get(named("okHttp")))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PlayerApi::class.java)
    }

    single(named("okHttp")){
        OkHttpClient.Builder().apply {
            connectTimeout(60, TimeUnit.SECONDS)
            readTimeout(30, TimeUnit.SECONDS)
        }.build()
    }

}