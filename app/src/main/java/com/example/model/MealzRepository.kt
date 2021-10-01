package com.example.model

import com.example.model.api.MealzWebService
import com.example.model.response.MealzCategoriesResponse
import com.example.model.response.MealzResponse

class MealzRepository(private val webService: MealzWebService = MealzWebService()) {

    private var cachedMeals = listOf<MealzResponse>()

    suspend fun getMealz(): MealzCategoriesResponse {
        val response = webService.getMealz()
        cachedMeals = response.categories
        return response
    }

    fun getMeal(id: Int): MealzResponse? {
        return cachedMeals.firstOrNull {
            it.id == id
        }
    }

    companion object {
        @Volatile
        private var instance: MealzRepository? = null

        fun getInstance() = instance ?: synchronized(this) {
            instance ?: MealzRepository().also { instance = it }
        }
    }

}
