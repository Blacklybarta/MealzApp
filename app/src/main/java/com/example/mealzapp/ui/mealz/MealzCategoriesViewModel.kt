package com.example.mealzapp.ui.mealz

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.model.MealzRepository
import com.example.model.response.MealzResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MealzCategoriesViewModel(
    private val repository: MealzRepository = MealzRepository.getInstance()
) : ViewModel() {

    val mealzState: MutableState<List<MealzResponse>> = mutableStateOf(emptyList())

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val mealz = getMealz()
            mealzState.value = mealz
        }
    }

    private suspend fun getMealz(): List<MealzResponse> {
        return repository.getMealz().categories
    }

}
