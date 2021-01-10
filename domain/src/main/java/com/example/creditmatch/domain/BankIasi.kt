package com.example.creditmatch.domain

class BankIasi(headquater: Address) : Bank(headquater) {
    override fun getCredit(request: CreditRequest): Credit? {
        val client = request.client
        if (request.amount / (client.salary + 1) < 60)
            return null
        return Credit(
            request.amount,
            request.time,
            CreditType.PREMIUM,
            this
        )
    }
}