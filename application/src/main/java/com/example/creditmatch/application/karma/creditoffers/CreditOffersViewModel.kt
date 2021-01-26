package com.example.creditmatch.application.karma.creditoffers

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.creditmatch.application.utils.SingleLiveEvent

class CreditOffersViewModel
@ViewModelInject
constructor(
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val name: LiveData<String> = MutableLiveData("")

    val showDashboardScreen = SingleLiveEvent<Nothing>()
    fun showDashboardScreen() {
        showDashboardScreen.call()
    }
}