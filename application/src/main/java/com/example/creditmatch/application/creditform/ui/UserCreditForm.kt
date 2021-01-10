package com.example.creditmatch.application.creditform.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.viewModel

@Composable
fun UserCreditForm(nextBtn: () -> Unit) {
    val viewModel = viewModel<CreditFormViewModel>()
    val firstName by viewModel.firstName.observeAsState()
    val lastName by viewModel.lastName.observeAsState()
    val age by viewModel.age.observeAsState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.preferredHeight(16.dp))
        Text("Let us know you!")
        Spacer(modifier = Modifier.preferredHeight(80.dp))
        OutlinedTextField(
            value = firstName ?: "",
            onValueChange = { viewModel.onFirstNameChanged(it) },
            label = {
                Text("First Name")
            }
        )
        Spacer(modifier = Modifier.preferredHeight(16.dp))
        OutlinedTextField(
            value = lastName ?: "",
            onValueChange = { viewModel.onLastNameChanged(it) },
            label = {
                Text("Last Name")
            }
        )
        Spacer(modifier = Modifier.preferredHeight(16.dp))
        OutlinedTextField(
            value = age.toString(),
            onValueChange = { viewModel.onAgeChanged(it.toIntOrNull() ?: 0) },
            label = {
                Text("Age")
            }
        )
        Spacer(modifier = Modifier.preferredHeight(16.dp))
        Button(onClick = nextBtn) {
            Text("Next")
        }
    }
}