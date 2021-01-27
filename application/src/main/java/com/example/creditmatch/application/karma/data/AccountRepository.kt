package com.example.creditmatch.application.karma.data

import com.example.creditmatch.domain.User
import com.example.creditmatch.domain.karma.Account
import kotlinx.coroutines.flow.Flow

interface AccountRepository {
    suspend fun save(account: Account)
    fun getAll(): Flow<Account>
    suspend fun getAccount(email: String): Account?
}