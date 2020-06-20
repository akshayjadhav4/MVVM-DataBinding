package com.example.mvvmdatabinding

class MarsRepository(private val api: MarsApi) : SaveApiRequest() {

    suspend fun getMarsProperties() = apiRequest { api.getProperties() }
}