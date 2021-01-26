package com.example.creditmatch.application.karma.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.creditmatch.application.BR
import com.example.creditmatch.application.R
import com.example.creditmatch.application.databinding.FragmentCreditScoringBinding
import com.example.creditmatch.application.databinding.FragmentRegisterBinding
import com.example.creditmatch.application.karma.creditscoring.CreditScoringViewModel


class RegisterFragment : Fragment() {
    //region Vars
    private val viewModel: RegisterViewModel by activityViewModels()
    private lateinit var binding: FragmentRegisterBinding
    //endregion

    //region Life cycle
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        binding.setVariable(BR.viewModel, viewModel)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.showDataInputScreen.observe(viewLifecycleOwner) {
            findNavController().navigate(R.id.action_registerFragment_to_dataInputFragment)
        }
    }
    //endregion
}