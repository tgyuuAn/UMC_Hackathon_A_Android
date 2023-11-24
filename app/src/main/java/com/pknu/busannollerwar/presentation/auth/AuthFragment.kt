package com.pknu.busannollerwar.presentation.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.pknu.busannollerwar.R
import com.pknu.busannollerwar.databinding.FragmentAuthBinding
import com.pknu.busannollerwar.presentation.home.HomeEvent
import com.pknu.busannollerwar.presentation.util.BaseFragment
import com.pknu.busannollerwar.presentation.util.repeatOnStarted
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class AuthFragment : BaseFragment<FragmentAuthBinding, AuthViewModel>(FragmentAuthBinding::inflate) {

    override val fragmentViewModel: AuthViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setBinding()
    }
    private fun setBinding() = binding.apply {
        viewModel = fragmentViewModel.apply {
            viewLifecycleOwner.apply {
                repeatOnStarted { eventFlow.collect { handleEvent(it) } }
            }
        }
    }

    private fun handleEvent(event: AuthEvent) {
        when (event) {
            else -> {}
        }
    }
}