package com.pknu.busannollerwar.presentation.thingstodo.articleDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.pknu.busannollerwar.R
import com.pknu.busannollerwar.databinding.FragmentArticleDetailBinding
import com.pknu.busannollerwar.presentation.util.BaseFragment


class ArticleDetailFragment : BaseFragment<FragmentArticleDetailBinding, ArticleDetailViewModel>(FragmentArticleDetailBinding::inflate) {
    override val fragmentViewModel: ArticleDetailViewModel by viewModels()
}