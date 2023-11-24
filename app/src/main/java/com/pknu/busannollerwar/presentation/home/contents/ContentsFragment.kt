package com.pknu.busannollerwar.presentation.home.contents

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.pknu.busannollerwar.databinding.FragmentContentsBinding
import com.pknu.busannollerwar.presentation.home.HomeEvent
import com.pknu.busannollerwar.presentation.home.HomeFragmentDirections
import com.pknu.busannollerwar.presentation.util.BaseFragment
import com.pknu.busannollerwar.presentation.util.repeatOnStarted
import kotlinx.serialization.json.JsonNull.content

class ContentsFragment : BaseFragment<FragmentContentsBinding, ContentsViewModel>(
    FragmentContentsBinding::inflate
) {
    override val fragmentViewModel: ContentsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setBinding()
    }

    private fun setBinding() = binding.apply {
        val args : ContentsFragmentArgs by navArgs()
        val content = args.content

        viewModel = fragmentViewModel.apply {
            viewLifecycleOwner.apply {
                repeatOnStarted { eventFlow.collect { handleEvent(it) } }
            }
        }

    }

    private fun handleEvent(event: ContentsEvent) {
        when (event) {
            else -> {}
        }
    }
}