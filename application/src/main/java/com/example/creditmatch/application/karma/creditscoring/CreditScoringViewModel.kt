package com.example.creditmatch.application.karma.creditscoring

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.creditmatch.application.utils.SingleLiveEvent

class CreditScoringViewModel
@ViewModelInject
constructor(
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val showLogInScreen = SingleLiveEvent<Nothing>()
    fun showLogInScreen() {
        showLogInScreen.call()
    }

    val showRegisterScreen = SingleLiveEvent<Nothing>()
    fun showRegisterScreen() {
        showRegisterScreen.call()
    }
}