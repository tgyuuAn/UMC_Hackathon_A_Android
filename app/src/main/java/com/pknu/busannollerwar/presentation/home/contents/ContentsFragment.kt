package com.pknu.busannollerwar.presentation.home.contents

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.pknu.busannollerwar.databinding.FragmentContentsBinding
import com.pknu.busannollerwar.presentation.home.HomeEvent
import com.pknu.busannollerwar.presentation.home.HomeFragmentDirections
import com.pknu.busannollerwar.presentation.util.BaseFragment
import com.pknu.busannollerwar.presentation.util.repeatOnStarted

class ContentsFragment : BaseFragment<FragmentContentsBinding, ContentsViewModel>(
    FragmentContentsBinding::inflate
) {
    override val fragmentViewModel: ContentsViewModel by viewModels()

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

        setRecyclerView()
        homeListAdapter.submitList(listOf(Contents.KPOP, Contents.COOKING, Contents.HANBOK))
    }

    private fun handleEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.NavigateToContents -> {
                val action =
                    HomeFragmentDirections.actionGlobalContentsFragment(event.contents.value)
                findNavController().navigate(action)
            }
        }
    }
}