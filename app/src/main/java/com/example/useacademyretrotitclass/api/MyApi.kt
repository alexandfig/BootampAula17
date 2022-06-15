package com.example.useacademyretrotitclass.api

import okhttp3.OkHttpClient
import okhttp3.Route
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MyApi(private val baseUrl: String) {

    fun create():RoutesApi{
        return Retrofit
            .Builder() // Avisa que algo vai ser construído
            .baseUrl(baseUrl) // Atribuião da base url
            .addConverterFactory(GsonConverterFactory.create()) // Criação do conversor de JSON para classe kotlin
            .client(OkHttpClient.Builder().build()) // Atribuição do agente que irá efetuar a requisição em si
            .build()// termino de construr
            .create(RoutesApi::class.java)// Junção da url com o endpoint
    }
}