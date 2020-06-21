package com.example.mvvmdatabinding.data.repository

import com.example.mvvmdatabinding.data.network.MarsApi

class MarsRepository(private val api: MarsApi) : SaveApiRequest() {

    suspend fun getMarsProperties() = apiRequest { api.getProperties() }
}