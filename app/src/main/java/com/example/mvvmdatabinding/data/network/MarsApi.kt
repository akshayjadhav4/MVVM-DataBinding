package com.example.mvvmdatabinding.data.network

import com.example.mvvmdatabinding.data.models.MarsProperty
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MarsApi {

    @GET("realestate")
    suspend fun getProperties(): Response<List<MarsProperty>>

    companion object {
        operator fun invoke(): MarsApi {
            return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://mars.udacity.com/")
                .build()
                .create(MarsApi::class.java)
        }
    }
}