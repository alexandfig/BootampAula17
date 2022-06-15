package com.example.useacademyretrotitclass.api

import com.google.gson.annotations.SerializedName

data class MealResponse(
    @SerializedName("meals")
    val meals: List<Meal>
)

data class Meal(
    @SerializedName("strMeal")
    val mealName: String,
    @SerializedName("strMealThumb")
    val strMealThumb: String,
    @SerializedName("id")
    val idMeal: Int
)
/*
*
* {
      "strMeal": "Baked salmon with fennel & tomatoes",
      "strMealThumb": "https:\/\/www.themealdb.com\/images\/media\/meals\/1548772327.jpg",
      "idMeal": "52959"
    }
*
*
* */