package com.example.creditmatch.dal

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.creditmatch.dal.dao.AccountDao
import com.example.creditmatch.dal.dao.UserDao
import com.example.creditmatch.dal.model.AccountEntity
import com.example.creditmatch.dal.model.UserEntity

@Database(
    entities = [
        UserEntity::class,
        AccountEntity::class
    ],
    version = 31
)
abstract class AppDatabase : RoomDatabase() {
    abstract val userDao: UserDao
    abstract val accountDao: AccountDao

    companion object {
        const val DATABASE_NAME = "application.db"
    }
}