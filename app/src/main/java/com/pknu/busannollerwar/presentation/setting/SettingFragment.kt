package com.pknu.busannollerwar.presentation.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.pknu.busannollerwar.R
import com.pknu.busannollerwar.databinding.FragmentSettingBinding
import com.pknu.busannollerwar.presentation.util.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingFragment :
    BaseFragment<FragmentSettingBinding, SettingViewModel>(FragmentSettingBinding::inflate) {

    override val fragmentViewModel: SettingViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}