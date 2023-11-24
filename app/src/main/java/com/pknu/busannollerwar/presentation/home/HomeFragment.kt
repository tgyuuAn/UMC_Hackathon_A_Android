package com.pknu.busannollerwar.presentation.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.pknu.busannollerwar.databinding.FragmentHomeBinding
import com.pknu.busannollerwar.presentation.home.contents.Contents
import com.pknu.busannollerwar.presentation.util.BaseFragment
import com.pknu.busannollerwar.presentation.util.repeatOnStarted
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment :
    BaseFragment<FragmentHomeBinding, HomeViewModel>(FragmentHomeBinding::inflate) {

    override val fragmentViewModel: HomeViewModel by viewModels()
    val homeListAdapter: HomeListAdapter by lazy { HomeListAdapter(fragmentViewModel) }

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

    private fun setRecyclerView() = binding.rvHome.apply {
        adapter = homeListAdapter
        layoutManager = LinearLayoutManager(requireActivity())
        addItemDecoration(HomeListDecoration(requireContext()))
    }
}