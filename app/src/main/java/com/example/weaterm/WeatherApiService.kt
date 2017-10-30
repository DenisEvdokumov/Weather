package com.example.weaterm

import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Денис on 30.10.2017.
 */
interface WeatherApiService {
    @GET("current.json")
    fun hitCountCheck(@Query("key") key: String,
                      @Query("q") q: String): Observable<Model.Result>

    companion object {
        fun create(): WeatherApiService {

            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(
                            RxJava2CallAdapterFactory.create())
                    .addConverterFactory(
                            GsonConverterFactory.create())
                    .baseUrl("https://api.apixu.com/v1/")
                    .build()

            return retrofit.create(WeatherApiService::class.java)
        }
    }
}