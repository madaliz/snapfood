package com.example.snapfoodtask

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.snapfoodtask.model.PeopleResponse
import com.example.snapfoodtask.model.Person
import com.example.snapfoodtask.repository.SWAPIRepository

import com.example.snapfoodtask.viewmodel.PersonViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class PersonViewModelTest {

    private val testDispatcher = TestCoroutineDispatcher()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: PersonViewModel
    private lateinit var repository: SWAPIRepository

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        repository = mockk()
        viewModel = PersonViewModel(repository)
    }

    @Test
    fun `searchPeople updates people list correctly`() = runBlockingTest {
        val peopleList = listOf(Person(1, "Luke Skywalker", "19BBY", "172", emptyList(),"", emptyList()))
        val response = PeopleResponse(1, "",null,peopleList)
        coEvery { repository.searchPerson(any(), any()) } returns response

        viewModel.searchPeople("Luke")

        assert(viewModel.people.value == peopleList)
        assert(!viewModel.hasMoreData.value)
    }
}