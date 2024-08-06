package com.example.snapfoodtask.model

data class PeopleResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Person>
)
