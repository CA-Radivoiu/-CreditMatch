package com.example.creditmatch.application.karma.login

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.creditmatch.application.karma.data.AccountRepository
import com.example.creditmatch.application.utils.SingleLiveEvent
import com.example.creditmatch.application.utils.Vars
import com.example.creditmatch.application.utils.isNotNull
import kotlinx.coroutines.launch

class LogInViewModel
@ViewModelInject
constructor(
    private val accountRepository: AccountRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    val emailAdress: MutableLiveData<String> = MutableLiveData("")
    val password: MutableLiveData<String> = MutableLiveData("")
    val showToastAlert = SingleLiveEvent<String>()

    val showDashboardScreen = SingleLiveEvent<Nothing>()

    fun showDashboardScreen() = viewModelScope.launch {
        if (emailAdress.value.isNullOrEmpty()) {
            showToastAlert.value = "Email address is required!"
            return@launch
        }
        if (password.value.isNullOrEmpty()) {
            showToastAlert.value = "Password is required!"
            return@launch
        }
        val account = accountRepository.getAccount(emailAdress.value!!)
        if (account.isNotNull) {
            if (account!!.password == password.value!!) {
                Vars.firstName = account!!.firstName
                showDashboardScreen.call()
            }

            else
                showToastAlert.value = "Invalid credentials!"
        } else {
            showToastAlert.value = "Invalid credentials!"
            return@launch
        }

    }
}