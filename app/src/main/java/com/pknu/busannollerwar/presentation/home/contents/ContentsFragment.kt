package com.pknu.busannollerwar.presentation.home.contents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.pknu.busannollerwar.R
import com.pknu.busannollerwar.databinding.FragmentContentsBinding
import com.pknu.busannollerwar.presentation.util.BaseFragment

class ContentsFragment : BaseFragment<FragmentContentsBinding, ContentsViewModel>(
    FragmentContentsBinding::inflate) {
    override val fragmentViewModel: ContentsViewModel by viewModels()

}