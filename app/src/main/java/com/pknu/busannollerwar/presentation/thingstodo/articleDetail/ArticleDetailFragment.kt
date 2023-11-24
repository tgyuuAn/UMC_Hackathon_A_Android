package com.pknu.busannollerwar.presentation.thingstodo.articleDetail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.pknu.busannollerwar.R
import com.pknu.busannollerwar.databinding.FragmentArticleDetailBinding
import com.pknu.busannollerwar.presentation.util.BaseFragment
import com.pknu.busannollerwar.presentation.util.repeatOnStarted


class ArticleDetailFragment :
    BaseFragment<FragmentArticleDetailBinding, ArticleDetailViewModel>(FragmentArticleDetailBinding::inflate) {
    override val fragmentViewModel: ArticleDetailViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setBinding()
    }

    private fun setBinding() = binding.apply {
        val args: ArticleDetailFragmentArgs by navArgs()
        val nowArticle = args.article
        article = nowArticle

        viewModel = fragmentViewModel.apply {
            viewLifecycleOwner.apply {
                repeatOnStarted { eventFlow.collect { handleEvent(it) } }
            }
        }
    }

    private fun handleEvent(event: ArticleDetailEvent) {
        when (event) {
            is ArticleDetailEvent.NavigateToReview -> findNavController().navigate(R.id.reviewFragment)
        }
    }
}