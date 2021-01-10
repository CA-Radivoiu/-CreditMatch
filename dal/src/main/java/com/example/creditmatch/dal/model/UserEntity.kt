package com.example.creditmatch.dal.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users_TD")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
)