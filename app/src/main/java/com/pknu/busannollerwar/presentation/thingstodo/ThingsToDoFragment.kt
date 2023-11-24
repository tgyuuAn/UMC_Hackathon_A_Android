package com.pknu.busannollerwar.presentation.thingstodo

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.pknu.busannollerwar.data.model.Article
import com.pknu.busannollerwar.databinding.FragmentThingsToDoBinding
import com.pknu.busannollerwar.presentation.util.BaseFragment
import com.pknu.busannollerwar.presentation.util.repeatOnStarted
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ThingsToDoFragment :
    BaseFragment<FragmentThingsToDoBinding, ThingsToDoViewModel>(FragmentThingsToDoBinding::inflate) {
    override val fragmentViewModel: ThingsToDoViewModel by viewModels()
    val thingsToDoListAdapter: ThingsToDoListAdapter by lazy {
        ThingsToDoListAdapter(
            fragmentViewModel
        )
    }

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
        thingsToDoListAdapter.submitList(
            listOf(
                Article(),
                Article(),
                Article(),
                Article(),
                Article(),
                Article()
            )
        )
    }

    private fun handleEvent(event: ThingsToDoEvent) {
        when (event) {
            is ThingsToDoEvent.NavigateToArticleDetail -> {
                val action =
                    ThingsToDoFragmentDirections.actionGlobalArticleDetailFragment(event.article)
                findNavController().navigate(action)
            }
        }
    }

    private fun setRecyclerView() = binding.rvThingsToDo.apply {
        adapter = thingsToDoListAdapter
        layoutManager = LinearLayoutManager(requireActivity())
        addItemDecoration(ThingsToDoListDecoration(requireContext()))
    }
}