package com.example.creditmatch.domain

data class CreditRequest(
    val client: Client,
    val amount: Int,
    val time: Int,
)