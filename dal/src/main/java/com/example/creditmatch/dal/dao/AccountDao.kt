package com.example.creditmatch.dal.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.creditmatch.dal.model.AccountEntity

@Dao
interface AccountDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAccount(account: AccountEntity)

    @Query("SELECT * FROM ACCOUNT_TD WHERE emailAdress == :email LIMIT 1")
    suspend fun getAccountByEmail(email: String): AccountEntity?
}