package com.pknu.busannollerwar.presentation.setting.languagesetting

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.pknu.busannollerwar.databinding.FragmentContentsReviewBinding
import com.pknu.busannollerwar.presentation.home.contents.contentsreview.ContentsReviewViewModel
import com.pknu.busannollerwar.presentation.util.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ContentsReviewFragment : BaseFragment<FragmentContentsReviewBinding, ContentsReviewViewModel>(FragmentContentsReviewBinding::inflate) {
    override val fragmentViewModel: ContentsReviewViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}