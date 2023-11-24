package com.pknu.busannollerwar.presentation.setting.languagesetting

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.pknu.busannollerwar.R
import com.pknu.busannollerwar.databinding.FragmentLanguageSettingBinding
import com.pknu.busannollerwar.databinding.FragmentMonthContentsBinding
import com.pknu.busannollerwar.presentation.home.monthcontents.MonthContentsViewModel
import com.pknu.busannollerwar.presentation.util.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MonthContentsFragment : BaseFragment<FragmentMonthContentsBinding, MonthContentsViewModel>(FragmentMonthContentsBinding::inflate) {
    override val fragmentViewModel: MonthContentsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}