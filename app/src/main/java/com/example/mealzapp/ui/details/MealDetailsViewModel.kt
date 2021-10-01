package com.example.mealzapp.ui.details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.model.MealzRepository
import com.example.model.response.MealzResponse

class MealDetailsViewModel(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val repository: MealzRepository = MealzRepository.getInstance()
    var mealState = mutableStateOf<MealzResponse?>(null)

    init {
        val mealId = savedStateHandle.get<Int>("mealCategoryId") ?: -1
        mealState.value = repository.getMeal(mealId)
    }


}