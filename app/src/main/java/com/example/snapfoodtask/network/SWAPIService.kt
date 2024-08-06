package com.example.snapfoodtask.network

import com.example.snapfoodtask.model.PeopleResponse
import com.example.snapfoodtask.model.PersonDetail
import com.example.snapfoodtask.model.PlanetDetail
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SWAPIService {

    @GET("people/")
    suspend fun getPeople():PeopleResponse

    @GET("people/{id}/")
    suspend fun getPersonDetail(@Path("id") id:Int):PersonDetail

    @GET("species/{id}/")
    suspend fun getPersonSpecies(@Path("id") id:Int):PersonDetail

    @GET("people/")
    suspend fun searchPerson(@Query("search") query: String,@Query("page") page:Int): PeopleResponse

    @GET("planets/{id}")
    suspend fun getPersonPlanets(@Path("id") id:Int):PlanetDetail
}