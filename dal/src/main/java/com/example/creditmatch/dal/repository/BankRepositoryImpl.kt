package com.example.creditmatch.dal.repository

import com.example.creditmatch.application.creditform.data.BankRepository
import com.example.creditmatch.domain.Address
import com.example.creditmatch.domain.Bank
import com.example.creditmatch.domain.BankCluj
import com.example.creditmatch.domain.BankIasi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class BankRepositoryImpl : BankRepository {
    override suspend fun getBanks(): List<Bank>  {
        val b1 = BankCluj(
            Address(
                "Romania",
                "Cluj-Napoca",
                "Avram Iancu",
                1,
            )
        )
        val b2 = BankIasi(
            Address(
                "Romania",
                "Iasi",
                "Stefan cel Mare",
                1,
            )
        )
        return listOf(b1, b2)
    }

}