package com.example.creditmatch.application.karma.creditscoredashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.creditmatch.application.BR
import com.example.creditmatch.application.R
import com.example.creditmatch.application.databinding.FragmentCreditScoreDashboardBinding
import com.example.creditmatch.application.databinding.FragmentLogInBinding
import com.example.creditmatch.application.karma.login.LogInViewModel


class CreditScoreDashboardFragment : Fragment() {
    //region Vars
    private val viewModel: CreditScoreDashboardViewModel by activityViewModels()
    private lateinit var binding: FragmentCreditScoreDashboardBinding
    //endregion

    //region Life cycle
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreditScoreDashboardBinding.inflate(inflater, container, false)
        binding.setVariable(BR.viewModel, viewModel)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.showDataInputScreen.observe(viewLifecycleOwner) {
            findNavController().navigate(R.id.action_creditScoreDashboardFragment_to_dataInputFragment)
        }
        viewModel.showCreditOffersScreen.observe(viewLifecycleOwner) {
            findNavController().navigate(R.id.action_creditScoreDashboardFragment_to_creditOffersFragment)
        }
    }
    //endregion
}