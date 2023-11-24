package com.pknu.busannollerwar.presentation.setting

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.pknu.busannollerwar.R
import com.pknu.busannollerwar.databinding.FragmentSettingBinding
import com.pknu.busannollerwar.presentation.splash.SplashEvent
import com.pknu.busannollerwar.presentation.util.BaseFragment
import com.pknu.busannollerwar.presentation.util.repeatOnStarted
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingFragment :
    BaseFragment<FragmentSettingBinding, SettingViewModel>(FragmentSettingBinding::inflate) {

    override val fragmentViewModel: SettingViewModel by viewModels()

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

    private fun handleEvent(event: SettingEvent) {
        when (event) {
            is SettingEvent.NavigateToNotice -> openWebWithUri("https://alder-torta-e95.notion.site/12-ca7b40f7d4e8456e8beb9882052c5e7f".toUri())
            is SettingEvent.NavigateToLanguageSetting -> {}
            is SettingEvent.Logout -> {}
            is SettingEvent.Withdrawal -> {}
        }
    }

    private fun openWebWithUri(uri: Uri) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = uri
        startActivity(intent)
    }
}