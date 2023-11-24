package com.pknu.busannollerwar.presentation.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.pknu.busannollerwar.databinding.FragmentProfileBinding
import com.pknu.busannollerwar.presentation.setting.SettingEvent
import com.pknu.busannollerwar.presentation.util.BaseFragment
import com.pknu.busannollerwar.presentation.util.repeatOnStarted
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment :
    BaseFragment<FragmentProfileBinding, ProfileViewModel>(FragmentProfileBinding::inflate) {

    override val fragmentViewModel: ProfileViewModel by viewModels()

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

    private fun handleEvent(event: ProfileEvent) {
        when (event) {
            else -> {}
        }
    }
}