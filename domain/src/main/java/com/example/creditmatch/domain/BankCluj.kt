package com.example.creditmatch.domain

class BankCluj(headquater: Address) : Bank(headquater) {
    override fun getCredit(request: CreditRequest): Credit? {
        val client = request.client
        if (request.time + client.age  > 60)
            return null
        return Credit(
            request.amount,
            request.time,
            CreditType.PREMIUM,
            this
        )
    }
}