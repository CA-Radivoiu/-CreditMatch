package com.example.creditmatch.dal.repository

import com.example.creditmatch.application.creditform.data.UserRepository
import com.example.creditmatch.domain.User
import kotlinx.coroutines.flow.Flow

class UserRepositoryImpl : UserRepository {
    override suspend fun saveUser(user: User) {
        TODO("Not yet implemented")
    }

    override fun getAll(): Flow<User> {
        TODO("Not yet implemented")
    }

}