package com.example.snapfoodtask.repository

import com.example.snapfoodtask.network.SWAPIService
import javax.inject.Inject

class SWAPIRepository @Inject constructor(private val swapiService: SWAPIService) {

    suspend fun getPeople() = swapiService.getPeople()

    suspend fun getPersonSpecies(id:Int) = swapiService.getPersonSpecies(id)

    suspend fun getPersonPlanets(id:Int) = swapiService.getPersonPlanets(id)

    suspend fun searchPerson(query:String,page:Int) = swapiService.searchPerson(query,page)


}