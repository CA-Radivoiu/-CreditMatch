package com.example.creditmatch.application.creditform.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.creditmatch.application.BR
import com.example.creditmatch.application.R
import com.example.creditmatch.application.creditform.ui.CreditFormViewModel
import com.example.creditmatch.application.databinding.FragmentCreditFormBinding
import com.example.creditmatch.application.databinding.FragmentStartBinding


class CreditFormFragment : Fragment() {
    private val viewModel: CreditFormViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentCreditFormBinding.inflate(inflater, container, false)
        binding.setVariable(BR.viewModel, viewModel)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.showResultScreenEvent.observe(viewLifecycleOwner) {
            findNavController().navigate(R.id.action_creditFormFragment_to_resultFragment)
        }
    }
}