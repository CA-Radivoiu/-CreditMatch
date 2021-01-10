package com.example.creditmatch.application.creditform.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.creditmatch.application.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserCreditFormFragment : Fragment() {
    private val viewModel: CreditFormViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_credit_form, container, false).apply {
            findViewById<ComposeView>(R.id.compose_view).setContent {
                MaterialTheme {
                    UserCreditForm {
                        findNavController().navigate(R.id.action_userCreditFormFragment_to_creditFormFragment)
                    }
                }
            }
        }
    }
}

