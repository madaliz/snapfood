package com.example.snapfoodtask.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.snapfoodtask.model.Person
import com.example.snapfoodtask.model.PersonDetail
import com.example.snapfoodtask.model.PlanetDetail
import com.example.snapfoodtask.repository.SWAPIRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


@HiltViewModel
class PersonViewModel @Inject constructor(private  val repository: SWAPIRepository): ViewModel() {

    private val _people = MutableStateFlow<List<Person>>(emptyList())
    val people: StateFlow<List<Person>> = _people
    private val _personDetail = MutableStateFlow<PersonDetail?>(null)
    val personDetail: StateFlow<PersonDetail?> = _personDetail

    private val _personPlanets = MutableStateFlow<PlanetDetail?>(null)
    val personPlanets : StateFlow<PlanetDetail?> = _personPlanets

    private var currentPage = 1
    private var isLastPage = false

    private val _hasMoreData = MutableStateFlow(true)
    val hasMoreData: StateFlow<Boolean> = _hasMoreData

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error


    fun searchPeople(query: String) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = repository.searchPerson(query, currentPage)
                val nextPage = response.next.isNullOrEmpty()
                if (currentPage == 1) {
                    _people.value = response.results
                } else {
                    _people.value = _people.value + response.results
                }
                isLastPage = nextPage
                _hasMoreData.value = !isLastPage
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun resetSearch() {
        currentPage = 1
        _hasMoreData.value = true
        _people.value = emptyList()
    }

    fun loadMorePeople(query: String) {
        if (isLastPage || _isLoading.value) return

        currentPage++
        searchPeople(query)
    }
    fun clearPeople() {
        _people.value = emptyList()
        currentPage = 1
        _hasMoreData.value = true
    }

    fun fetchPersonSpecies(id: Int) {
        viewModelScope.launch {
            _personDetail.value = repository.getPersonSpecies(id)
        }
    }

    fun fetchPersonPlanets(id:Int){
        viewModelScope.launch {
            _personPlanets.value = repository.getPersonPlanets(id)
        }
    }
}