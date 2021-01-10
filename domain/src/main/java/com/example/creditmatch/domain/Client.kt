package com.example.creditmatch.domain

class Client(
    id: Int? = null,
    firstName: String,
    lastName: String,
    age: Int,
    val salary: Int = 0,
    val credits: MutableList<Credit> = mutableListOf()
): User(id, firstName, lastName, age)