package com.example.creditmatch.domain

data class Credit(
    val amount: Int,
    val time: Int,
    val type: CreditType,
    val bank: Bank
) {
    override fun toString(): String {
        return "You get a credit in amount of $amount for $time months at bank $bank "
    }
}