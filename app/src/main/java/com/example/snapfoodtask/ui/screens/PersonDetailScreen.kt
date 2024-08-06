package com.example.snapfoodtask.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.snapfoodtask.model.Person
import com.example.snapfoodtask.viewmodel.PersonViewModel

@Composable
fun PersonDetailScreen(person: Person, viewModel: PersonViewModel = hiltViewModel()) {
    val personDetail by viewModel.personDetail.collectAsState()
    val personPlanets by viewModel.personPlanets.collectAsState()
    val loading by viewModel.isLoading.collectAsState()
    val error by viewModel.error.collectAsState()

    // Function to extract number from URL
    fun extractNumberFromUrl(url: String): Int? {
        val parts = url.split("/")
        return parts.findLast { it.isNotEmpty() }?.toIntOrNull()
    }

    // Fetch details when the person changes
    LaunchedEffect(person) {
        if (person.species.isNotEmpty()) {
            val url = person.species.first()
            extractNumberFromUrl(url)?.let { id -> viewModel.fetchPersonSpecies(id) }
        }
        if (person.homeworld.isNotEmpty()) {
            val url = person.homeworld
            extractNumberFromUrl(url)?.let { id -> viewModel.fetchPersonPlanets(id) }
        }
    }

    // Display content based on the current state
    if (loading) {
        LoadingScreen()
    } else if (error != null) {
        ErrorScreen(error!!)
    } else {
        Column(modifier = Modifier.padding(16.dp)) {
            // Display person details
            Text(text = "Name: ${person.name}", style = MaterialTheme.typography.h6)
            Text(text = "Birth Year: ${person.birth_year}", style = MaterialTheme.typography.body1)
            Text(text = "Height: ${person.height} cm", style = MaterialTheme.typography.body1)

            // Display species details if available
            personDetail?.let {
                Text(text = "Species Name: ${it.name}", style = MaterialTheme.typography.body1)
                Text(text = "Language: ${it.language}", style = MaterialTheme.typography.body1)
            }

            // Display planet details if available
            personPlanets?.let {
                Text(text = "Planet Population: ${it.population}", style = MaterialTheme.typography.body1)
            }

            // Display homeworld
            Text(text = "Homeworld: ${person.homeworld}", style = MaterialTheme.typography.body1)

            // Display films
            Text(text = "Films:", style = MaterialTheme.typography.h6)
            LazyColumn {
                itemsIndexed(person.films){index, item ->
                    Text(text = item, style = MaterialTheme.typography.body1)

                }
            }
        }
    }
}


@Composable
fun ErrorScreen(message: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = message, color = Color.Red)
    }
}