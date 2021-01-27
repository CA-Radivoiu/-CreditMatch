package com.example.creditmatch.application.karma.register

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.creditmatch.application.creditform.data.UserRepository
import com.example.creditmatch.application.karma.data.AccountRepository
import com.example.creditmatch.application.utils.SingleLiveEvent
import com.example.creditmatch.application.utils.Vars
import com.example.creditmatch.domain.karma.Account
import kotlinx.coroutines.launch

class RegisterViewModel
@ViewModelInject
constructor(
    private val accountRepository: AccountRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val firstName: MutableLiveData<String> = MutableLiveData("")
    val lastName: MutableLiveData<String> = MutableLiveData("")
    val emailAdress: MutableLiveData<String> = MutableLiveData("")
    val password: MutableLiveData<String> = MutableLiveData("")
    val confPassword: MutableLiveData<String> = MutableLiveData("")

    val showDataInputScreen = SingleLiveEvent<Nothing>()
    val showToastAlert = SingleLiveEvent<String>()

    fun showDataInputScreen() {
        if (firstName.value.isNullOrEmpty()) {
            showToastAlert.value = "First name is required!"
            return
        }
        if (lastName.value.isNullOrEmpty()) {
            showToastAlert.value = "Last name is required!"
            return
        }
        if (emailAdress.value.isNullOrEmpty()) {
            showToastAlert.value = "Email address is required!"
            return
        }
        if (password.value.isNullOrEmpty()) {
            showToastAlert.value = "Password is required!"
            return
        }
        if (confPassword.value.isNullOrEmpty()) {
            showToastAlert.value = "Confirm password is required!"
            return
        }

        if (password.value != confPassword.value) {
            showToastAlert.value = "Password doesn't match"
            return
        }
        viewModelScope.launch {
            accountRepository.save(
                Account(
                    null,
                    firstName.value!!,
                    lastName.value!!,
                    emailAdress.value!!,
                    password.value!!
                )
            )
        }
        Vars.firstName = firstName.value!!
        showDataInputScreen.call()
    }
}