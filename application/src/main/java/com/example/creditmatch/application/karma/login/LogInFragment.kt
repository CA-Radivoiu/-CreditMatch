package com.example.creditmatch.application.karma.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.creditmatch.application.BR
import com.example.creditmatch.application.R
import com.example.creditmatch.application.databinding.FragmentCreditScoringBinding
import com.example.creditmatch.application.databinding.FragmentLogInBinding
import com.example.creditmatch.application.karma.creditscoring.CreditScoringViewModel


class LogInFragment : Fragment() {

    //region Vars
    private val viewModel: LogInViewModel by activityViewModels()
    private lateinit var binding: FragmentLogInBinding
    //endregion

    //region Life cycle
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLogInBinding.inflate(inflater, container, false)
        binding.setVariable(BR.viewModel, viewModel)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.showDashboardScreen.observe(viewLifecycleOwner) {
            findNavController().navigate(R.id.action_logInFragment_to_creditScoreDashboardFragment)
        }
        viewModel.showToastAlert.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }
    }
    //endregion
}