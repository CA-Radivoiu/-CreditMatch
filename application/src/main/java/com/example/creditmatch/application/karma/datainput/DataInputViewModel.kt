package com.example.creditmatch.application.karma.datainput

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.creditmatch.application.utils.SingleLiveEvent
import com.example.creditmatch.application.utils.Vars
import java.lang.Math.abs
import kotlin.math.roundToInt

class DataInputViewModel
@ViewModelInject
constructor(
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    val gender: MutableLiveData<String> = MutableLiveData("")
    val years: MutableLiveData<String> = MutableLiveData("")
    val monthSalary: MutableLiveData<String> = MutableLiveData("")
    val monthlyFixed: MutableLiveData<String> = MutableLiveData("")
    val amountDebt: MutableLiveData<String> = MutableLiveData("")
    val amountDuration: MutableLiveData<String> = MutableLiveData("")

    val name: LiveData<String> = MutableLiveData("")
    val showDashboardScreen = SingleLiveEvent<Nothing>()
    fun showDashboardScreen() {
        val gender = gender.value?.toFloatOrNull() ?: 0f
        val years = years.value?.toFloatOrNull() ?: 0f
        val monthSalary = monthSalary.value?.toFloatOrNull() ?: 0f
        val monthlyFixed = monthlyFixed.value?.toFloatOrNull() ?: 0f
        val amountDebt = amountDebt.value?.toFloatOrNull() ?: 0f
        val amountDuration = amountDuration.value?.toFloatOrNull() ?: 0f
        val regressionOutPut = 1.39 + gender * (-0.21) + years * (-1.07) + monthSalary * (-0.21)
        +monthlyFixed * (-0.15) + amountDebt + (-0.18) + amountDuration * (0.4)

        if (abs(regressionOutPut) > 6158) {
           Vars.score = 100
        } else if (abs(regressionOutPut) < 371) {
          Vars.score = 25
        } else {
            val res =  abs(regressionOutPut)-371 *  (100f - 25f)/5787f +25
            Vars.score = res.roundToInt()
        }
        showDashboardScreen.call()
    }
}