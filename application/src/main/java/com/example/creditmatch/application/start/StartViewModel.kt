package com.example.creditmatch.application.start

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.creditmatch.application.utils.SingleLiveEvent

class StartViewModel
@ViewModelInject
constructor(
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val showCreditFormEvent = SingleLiveEvent<Nothing>()
    fun showCreditForm() {
        showCreditFormEvent.call()
    }
}