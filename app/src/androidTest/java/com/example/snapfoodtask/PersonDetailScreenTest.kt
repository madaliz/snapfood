package com.example.snapfoodtask

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.*
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable
import androidx.compose.material.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.hasText
import com.example.snapfoodtask.ui.screens.PersonDetailScreen
import com.example.snapfoodtask.viewmodel.PersonViewModel
import com.example.snapfoodtask.model.Person
import com.example.snapfoodtask.model.PersonDetail
import com.example.snapfoodtask.model.PlanetDetail
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import io.mockk.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.*
import androidx.compose.material.*
import androidx.compose.foundation.layout.*
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before

@OptIn(ExperimentalCoroutinesApi::class)
class PersonDetailScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val mockViewModel = mockk<PersonViewModel>(relaxed = true)

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }


    @Test
    fun testPersonDetailScreenDisplaysPersonInfo() = runTest {
        val testPerson = Person(
            id = 1,
            name = "Luke Skywalker",
            birth_year = "19BBY",
            height = "172",
            species = emptyList(),
            homeworld = "https://swapi.dev/api/planets/1/",
            films = listOf("https://swapi.dev/api/films/1/")
        )
        val testPersonDetail = PersonDetail(name = "Human", language = "Galactic Basic")
        val testPersonPlanets = PlanetDetail(name = "test", population = "1000")

        coEvery { mockViewModel.personDetail } returns MutableStateFlow(testPersonDetail)
        coEvery { mockViewModel.personPlanets } returns MutableStateFlow(testPersonPlanets)
        coEvery { mockViewModel.isLoading } returns MutableStateFlow(false)
        coEvery { mockViewModel.error } returns MutableStateFlow(null)

        composeTestRule.setContent {
            PersonDetailScreen(person = testPerson, viewModel = mockViewModel)
        }

        // Test if the person details are displayed correctly
        composeTestRule.onNodeWithText("Name: Luke Skywalker").assertIsDisplayed()
        composeTestRule.onNodeWithText("Birth Year: 19BBY").assertIsDisplayed()
        composeTestRule.onNodeWithText("Height: 172 cm").assertIsDisplayed()
        composeTestRule.onNodeWithText("Species Name: Human").assertIsDisplayed()
        composeTestRule.onNodeWithText("Language: Galactic Basic").assertIsDisplayed()
        composeTestRule.onNodeWithText("Planet Population: 1000").assertIsDisplayed()
        composeTestRule.onNodeWithText("Homeworld: https://swapi.dev/api/planets/1/").assertIsDisplayed()
        composeTestRule.onNodeWithText("Films:").assertIsDisplayed()
    }

    @Composable
    fun ErrorScreen(message: String) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = message, color = Color.Red)
        }
    }

}