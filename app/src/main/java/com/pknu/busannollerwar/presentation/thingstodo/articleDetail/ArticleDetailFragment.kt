package com.pknu.busannollerwar.presentation.thingstodo.articleDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.pknu.busannollerwar.R
import com.pknu.busannollerwar.databinding.FragmentArticleDetailBinding
import com.pknu.busannollerwar.presentation.thingstodo.ThingsToDoEvent
import com.pknu.busannollerwar.presentation.util.BaseFragment
import com.pknu.busannollerwar.presentation.util.repeatOnStarted


class ArticleDetailFragment : BaseFragment<FragmentArticleDetailBinding, ArticleDetailViewModel>(FragmentArticleDetailBinding::inflate) {
    override val fragmentViewModel: ArticleDetailViewModel by viewModels()

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

    private fun handleEvent(event: ArticleDetailEvent) {
        when (event) {
            is ArticleDetailEvent.NavigateToReview -> {}
        }
    }
}