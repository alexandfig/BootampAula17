package com.example.useacademyretrotitclass.api

import retrofit2.Response
import retrofit2.http.*


interface RoutesApi {

    @POST("/auth")
    suspend fun doAuthentication(
        @Body body: LoginBody
    ):Response<LoginResponse>


    @GET("/api/json/v1/1/filter.php")
    suspend fun getMeals(
        @Query("c") category: String
    ): Response<MealResponse>
}