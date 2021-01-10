package com.example.creditmatch.domain

class Employee(
    id: Int,
    firstName: String,
    lastName: String,
    age: Int,
    val jobTitle: String,
    val bankId: Int
): User(id, firstName, lastName, age)
