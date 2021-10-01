package com.example.model.response

import com.google.gson.annotations.SerializedName

data class MealzCategoriesResponse(
    val categories: List<MealzResponse>
)

data class MealzResponse(
    @SerializedName("idCategory")
    val id: Int,
    @SerializedName("strCategory")
    val name: String,
    @SerializedName("strCategoryDescription")
    val description: String,
    @SerializedName("strCategoryThumb")
    val imageUrl: String
)
