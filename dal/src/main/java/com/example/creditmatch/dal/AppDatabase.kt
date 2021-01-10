package com.example.creditmatch.dal

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.creditmatch.dal.dao.UserDao
import com.example.creditmatch.dal.model.UserEntity

@Database(
    entities = [
        UserEntity::class
    ],
    version = 31
)
abstract class AppDatabase : RoomDatabase() {
    abstract val userDao: UserDao

    companion object {
        const val DATABASE_NAME = "application.db"
    }
}