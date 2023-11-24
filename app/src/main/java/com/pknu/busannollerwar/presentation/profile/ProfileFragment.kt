package com.pknu.busannollerwar.presentation.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.pknu.busannollerwar.databinding.FragmentProfileBinding
import com.pknu.busannollerwar.presentation.util.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment :
    BaseFragment<FragmentProfileBinding, ProfileViewModel>(FragmentProfileBinding::inflate) {

    override val fragmentViewModel: ProfileViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}