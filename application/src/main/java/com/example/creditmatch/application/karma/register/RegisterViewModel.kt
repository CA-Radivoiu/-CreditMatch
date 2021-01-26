package com.example.creditmatch.application.karma.register

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.creditmatch.application.utils.SingleLiveEvent

class RegisterViewModel
@ViewModelInject
constructor(
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val showDataInputScreen = SingleLiveEvent<Nothing>()
    fun showDataInputScreen() {
        showDataInputScreen.call()
    }
}