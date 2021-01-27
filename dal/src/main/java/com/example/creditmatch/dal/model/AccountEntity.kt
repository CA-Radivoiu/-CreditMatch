package com.example.creditmatch.dal.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.creditmatch.domain.karma.Account

@Entity(tableName = "account_TD")
data class AccountEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val firstName: String,
    val lastName: String,
    val emailAdress: String,
    val password: String
)

val Account.asEntity: AccountEntity
        get() = AccountEntity(
            this.id ?: 1,
            this.firstName,
            this.lastName,
            this.emailAdress,
            this.password
        )

val AccountEntity.asDomainModel: Account
    get() = Account(
        this.id,
        this.firstName,
        this.lastName,
        this.emailAdress,
        this.password
    )