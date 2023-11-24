package com.pknu.busannollerwar.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pknu.busannollerwar.databinding.ItemHomeFirstImageCardBinding
import com.pknu.busannollerwar.databinding.ItemHomeSecondImageCardBinding
import com.pknu.busannollerwar.databinding.ItemHomeThirdImageCardBinding
import com.pknu.busannollerwar.presentation.home.contents.Contents

sealed class HomeViewHolder(private val binding: ViewDataBinding) :
    RecyclerView.ViewHolder(binding.root) {
    abstract fun bind()

    class FirstHomeViewHolder(
        private val fragmentViewModel: HomeViewModel,
        private val binding: ItemHomeFirstImageCardBinding
    ) :
        HomeViewHolder(binding) {
        override fun bind() {
            binding.viewModel = fragmentViewModel
        }
    }

    class SecondHomeViewHolder(
        private val fragmentViewModel: HomeViewModel,
        private val binding: ItemHomeSecondImageCardBinding
    ) :
        HomeViewHolder(binding) {
        override fun bind() {
            binding.viewModel = fragmentViewModel
        }
    }

    class ThirdHomeViewHolder(
        private val fragmentViewModel: HomeViewModel,
        private val binding: ItemHomeThirdImageCardBinding
    ) :
        HomeViewHolder(binding) {
        override fun bind() {
            binding.viewModel = fragmentViewModel
        }
    }
}

class HomeListAdapter(private val viewModel: HomeViewModel) :
    ListAdapter<Contents, HomeViewHolder>(object :
        DiffUtil.ItemCallback<Contents>() {
        override fun areItemsTheSame(oldItem: Contents, newItem: Contents): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: Contents, newItem: Contents): Boolean =
            oldItem == newItem
    }) {

    override fun getItemViewType(position: Int): Int = getItem(position).value

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder =
        when (viewType) {
            Contents.KPOP.value -> {
                val binding = ItemHomeFirstImageCardBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                HomeViewHolder.FirstHomeViewHolder(viewModel, binding)
            }

            Contents.COOKING.value -> {
                val binding = ItemHomeSecondImageCardBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                HomeViewHolder.SecondHomeViewHolder(viewModel, binding)
            }

            else -> {
                val binding = ItemHomeThirdImageCardBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                HomeViewHolder.ThirdHomeViewHolder(viewModel, binding)
            }
        }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind()
    }
}




