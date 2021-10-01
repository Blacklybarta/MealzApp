package com.example.model.api

import com.example.model.response.MealzCategoriesResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class MealzWebService {

    private val api: MealzApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(MealzApi::class.java)
    }

    suspend fun getMealz(): MealzCategoriesResponse {
        return api.getMealz()
    }

    interface MealzApi {
        @GET("categories.php")
        suspend fun getMealz(): MealzCategoriesResponse
    }

}
