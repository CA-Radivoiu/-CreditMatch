package com.example.creditmatch.domain


abstract class Bank(
    val headquater: Address,
    val atms: MutableList<Address> = mutableListOf(),
    val employees: MutableList<Employee> = mutableListOf(),
    val clients: MutableList<Client> = mutableListOf()
) {
    abstract fun getCredit(request: CreditRequest): Credit?
}