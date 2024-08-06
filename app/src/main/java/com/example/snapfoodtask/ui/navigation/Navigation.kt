package com.example.snapfoodtask.ui.navigation

import android.net.Uri
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.snapfoodtask.model.Person
import com.example.snapfoodtask.ui.screens.PersonDetailScreen
import com.example.snapfoodtask.ui.screens.SearchScreen
import com.google.gson.Gson

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController, startDestination = "search") {
        composable("search") {
            SearchScreen(onPersonSelected = { person ->
                val personJson = Gson().toJson(person)
                navController.navigate("person_detail/${Uri.encode(personJson)}")
            })
        }
        composable("person_detail/{personJson}") { backStackEntry ->
            val personJson = backStackEntry.arguments?.getString("personJson") ?: return@composable
            val person = Gson().fromJson(personJson, Person::class.java)
            PersonDetailScreen(person = person)
        }
    }
}