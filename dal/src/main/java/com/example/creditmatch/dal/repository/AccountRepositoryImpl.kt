package com.example.creditmatch.dal.repository

import com.example.creditmatch.application.karma.data.AccountRepository
import com.example.creditmatch.dal.dao.AccountDao
import com.example.creditmatch.dal.model.asDomainModel
import com.example.creditmatch.dal.model.asEntity
import com.example.creditmatch.domain.karma.Account
import kotlinx.coroutines.flow.Flow

class AccountRepositoryImpl(
    private val accountDao: AccountDao
) : AccountRepository {
    override suspend fun save(account: Account) {
        accountDao.saveAccount(account.asEntity)
    }

    override fun getAll(): Flow<Account> {
        TODO("Not yet implemented")
    }

    override suspend fun getAccount(email: String): Account? {
       return accountDao.getAccountByEmail(email)?.asDomainModel
    }


}