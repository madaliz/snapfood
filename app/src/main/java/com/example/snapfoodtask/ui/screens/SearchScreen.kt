package com.example.snapfoodtask.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.snapfoodtask.viewmodel.PersonViewModel
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.ListItem
import androidx.compose.ui.Alignment
import com.example.snapfoodtask.model.Person

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SearchScreen(onPersonSelected: (Person) -> Unit) {

    val viewModel: PersonViewModel = hiltViewModel()
    val people by viewModel.people.collectAsState()
    var query by remember { mutableStateOf("") }
    val isLoading by viewModel.isLoading.collectAsState()
    val error by viewModel.error.collectAsState()
    val hasMoreData by viewModel.hasMoreData.collectAsState()

    LaunchedEffect(query) {
        if (query.isNotEmpty()) {
            viewModel.resetSearch()
            viewModel.searchPeople(query)
        }
    }


    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = query,
            onValueChange = { newQuery ->
                query = newQuery
            },
            label = { Text("Search") }
        )
        Spacer(modifier = Modifier.height(8.dp))

        if (isLoading && people.isEmpty()) {
            LoadingScreen()
        } else if (error != null) {
            Text(text = error ?: "", style = MaterialTheme.typography.body1)
        } else if (people.isEmpty() && query.isNotEmpty()) {
            Text(text = "موردی یافت نشد", style = MaterialTheme.typography.body1)
        } else {
            LazyColumn {
                itemsIndexed(people) { index, person ->
                    ListItem(
                        modifier = Modifier.clickable { onPersonSelected(person) },
                        text = { Text(person.name) }
                    )

                    if (index == people.size - 1 && hasMoreData && !isLoading) {
                        LaunchedEffect(Unit) {
                            viewModel.loadMorePeople(query)
                        }
                    }
                }

                // Show a loading indicator at the end of the list
                if (isLoading && people.isNotEmpty()) {
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator()
                        }
                    }
                }
            }
        }
    }
}