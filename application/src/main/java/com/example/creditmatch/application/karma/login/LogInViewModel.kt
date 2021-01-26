package com.example.creditmatch.application.karma.login

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.creditmatch.application.utils.SingleLiveEvent

class LogInViewModel
@ViewModelInject
constructor(
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val showDashboardScreen = SingleLiveEvent<Nothing>()
    fun showDashboardScreen() {
        showDashboardScreen.call()
    }
}