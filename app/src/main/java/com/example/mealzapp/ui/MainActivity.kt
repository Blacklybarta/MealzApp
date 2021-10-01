package com.example.mealzapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mealzapp.ui.details.MealDetailsScreen
import com.example.mealzapp.ui.details.MealDetailsViewModel
import com.example.mealzapp.ui.mealz.MealsCategoriesScreen
import com.example.mealzapp.ui.theme.MealzAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealzAppTheme {
                FoodiezApp()
            }
        }
    }
}

@Composable
private fun FoodiezApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "destination_mealz_list") {
        composable(route = "destination_mealz_list") {
            MealsCategoriesScreen { mealCategoryId ->
                navController.navigate("destination_meal_detail/${mealCategoryId}")
            }
        }
        composable(
            route = "destination_meal_detail/{mealCategoryId}",
            arguments = listOf(navArgument("mealCategoryId") {
                type = NavType.IntType
            })
        ) {
            val viewModel: MealDetailsViewModel = viewModel()
            MealDetailsScreen(viewModel.mealState.value)
        }
    }
}