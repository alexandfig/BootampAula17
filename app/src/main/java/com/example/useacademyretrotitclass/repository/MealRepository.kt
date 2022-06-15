package com.example.useacademyretrotitclass.repository

import com.example.useacademyretrotitclass.api.MealResponse
import com.example.useacademyretrotitclass.api.MyApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class MealRepository {

    private var routesApi = MyApi("https://www.themealdb.com/").create()

    suspend fun getTheMeals(
        category: String
    ): Flow<MealResponse>{
        return flow {
            routesApi.getMeals(
                category
            ).let { response ->
                if(response.isSuccessful){
                    response.body()
                } else {
                    throw HttpException(response)
                }
            }?.let {
                emit(it)
            }
        }
    }
}