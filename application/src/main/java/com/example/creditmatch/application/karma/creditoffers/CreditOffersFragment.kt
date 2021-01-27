package com.example.creditmatch.application.karma.creditoffers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.creditmatch.application.BR
import com.example.creditmatch.application.R
import com.example.creditmatch.application.databinding.FragmentCreditOffersBinding
import com.example.creditmatch.application.databinding.FragmentLogInBinding
import com.example.creditmatch.application.karma.login.LogInViewModel
import com.example.creditmatch.application.utils.Vars


class CreditOffersFragment : Fragment() {
    //region Vars
    private val viewModel: CreditOffersViewModel by activityViewModels()
    private lateinit var binding: FragmentCreditOffersBinding
    //endregion

    //region Life cycle
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreditOffersBinding.inflate(inflater, container, false)
        binding.setVariable(BR.viewModel, viewModel)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.apply {
            setHasFixedSize(true)
            adapter = CreditOffersAdapter(mutableListOf(CreditOffer("$38.000", "4.5%"), CreditOffer("$38.000", "4.5%")))
        }
        viewModel.showDashboardScreen.observe(viewLifecycleOwner) {
            findNavController().navigate(R.id.action_creditOffersFragment_to_creditScoreDashboardFragment)
        }
        binding.t.text = "Hello ${Vars.firstName}"
    }
    //endregion
}