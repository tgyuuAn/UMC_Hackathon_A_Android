package com.pknu.busannollerwar.presentation.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.pknu.busannollerwar.databinding.FragmentHomeBinding
import com.pknu.busannollerwar.presentation.util.BaseFragment
import com.pknu.busannollerwar.presentation.util.repeatOnStarted
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment :
    BaseFragment<FragmentHomeBinding, HomeViewModel>(FragmentHomeBinding::inflate) {

    override val fragmentViewModel: HomeViewModel by viewModels()

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
    }

    private fun handleEvent(event: HomeEvent) {
        when (event) {
            else -> {}
        }
    }

    private fun setRecyclerView() = binding.rvHome.apply {
        adapter = myCommentListAdapter
        layoutManager = LinearLayoutManager(requireActivity())
    }
}