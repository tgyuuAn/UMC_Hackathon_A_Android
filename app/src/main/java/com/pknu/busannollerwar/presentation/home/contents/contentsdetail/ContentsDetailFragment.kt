package com.pknu.busannollerwar.presentation.setting.languagesetting

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.pknu.busannollerwar.databinding.FragmentMonthContentsBinding
import com.pknu.busannollerwar.presentation.home.contents.contentsdetail.ContentsDetailViewModel
import com.pknu.busannollerwar.presentation.util.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ContentsDetailFragment : BaseFragment<FragmentMonthContentsBinding, ContentsDetailViewModel>(FragmentMonthContentsBinding::inflate) {
    override val fragmentViewModel: ContentsDetailViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}