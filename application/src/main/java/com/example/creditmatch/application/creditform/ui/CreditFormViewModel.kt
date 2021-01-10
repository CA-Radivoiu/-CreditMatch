package com.example.creditmatch.application.creditform.ui

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.creditmatch.application.BankManager
import com.example.creditmatch.application.creditform.data.BankRepository
import com.example.creditmatch.application.creditform.data.UserRepository
import com.example.creditmatch.application.utils.SingleLiveEvent
import com.example.creditmatch.domain.Client
import com.example.creditmatch.domain.CreditRequest
import kotlinx.coroutines.launch

class CreditFormViewModel
@ViewModelInject
constructor(
    private val bankRepository: BankRepository,
    private val userRepository: UserRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _creditMessage = MutableLiveData<String>()
    val creditMessage: LiveData<String> = _creditMessage

    private val _firstName = MutableLiveData<String>()
    val firstName: LiveData<String> = _firstName

    private val _lastName = MutableLiveData<String>()
    val lastName: LiveData<String> = _lastName

    private val _age = MutableLiveData<Int>(18)
    val age: LiveData<Int> = _age

    private val _amount = MutableLiveData<String>()
    val amount: LiveData<String> = _amount

    private val _time = MutableLiveData<String>()
    val time: LiveData<String> = _time

    fun onFirstNameChanged(value: String) {
        _firstName.value = value
    }

    fun onLastNameChanged(value: String) {
        _lastName.value = value
    }

    fun onAgeChanged(value: Int) {
        _age.value = value
    }
    val showResultScreenEvent = SingleLiveEvent<Nothing>()
    fun getCredit() = viewModelScope.launch {
        val client = Client(
            firstName = firstName.value ?: "",
            lastName = lastName.value ?: "",
            age = age.value ?: 18
            )
        val request = CreditRequest(client, amount.value?.toIntOrNull() ?: 1000, time.value?.toIntOrNull() ?: 360)
        val manager = BankManager(bankRepository.getBanks())
        val result = manager.getCredit(request)
        _creditMessage.value = result?.toString()
        showResultScreenEvent.call()
    }
}