package com.example.creditmatch.application

import com.example.creditmatch.domain.Bank
import com.example.creditmatch.domain.Credit
import com.example.creditmatch.domain.CreditRequest

class BankManager(private val banks: List<Bank>) {
    fun getCredit(request: CreditRequest): Credit? {
        return banks.mapNotNull { it.getCredit(request) }.firstOrNull()
    }
}