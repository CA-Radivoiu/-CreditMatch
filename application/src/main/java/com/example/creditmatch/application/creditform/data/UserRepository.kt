package com.example.creditmatch.application.creditform.data

import com.example.creditmatch.domain.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun saveUser(user: User)
    fun getAll(): Flow<User>
}