package com.example.creditmatch.application.karma.creditscoredashboard

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.creditmatch.application.utils.SingleLiveEvent

class CreditScoreDashboardViewModel
@ViewModelInject
constructor(
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val name: LiveData<String> = MutableLiveData("")

    val showDataInputScreen = SingleLiveEvent<Nothing>()
    fun showDataInputScreen() {
        showDataInputScreen.call()
    }

    val showCreditOffersScreen = SingleLiveEvent<Nothing>()
    fun showCreditOffersScreen() {
        showCreditOffersScreen.call()
    }
}