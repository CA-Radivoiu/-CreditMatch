package com.example.creditmatch.application.creditform.data

import com.example.creditmatch.domain.Bank
import kotlinx.coroutines.flow.Flow

interface BankRepository {
    suspend fun getBanks(): List<Bank>
}