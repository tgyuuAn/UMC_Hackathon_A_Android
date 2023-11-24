package com.pknu.busannollerwar.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pknu.busannollerwar.databinding.ItemHomeFirstImageCardBinding
import com.pknu.busannollerwar.databinding.ItemHomeSecondImageCardBinding

sealed class HomeViewHolder(private val binding: ViewDataBinding) :
    RecyclerView.ViewHolder(binding.root) {
    abstract fun bind()

    class FirstHomeViewHolder(private val binding: ItemHomeFirstImageCardBinding) :
        HomeViewHolder(binding) {
        override fun bind() {

        }
    }

    class SecondHomeViewHolder(private val binding: ItemHomeSecondImageCardBinding) :
        HomeViewHolder(binding) {
        override fun bind() {

        }
    }
}

class HomeListAdapter : ListAdapter<Int, HomeViewHolder>(object :
    DiffUtil.ItemCallback<Int>() {
    override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean = oldItem == newItem
    override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean = oldItem == newItem
}) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = ItemHomeFirstImageCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HomeViewHolder.FirstHomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind()
    }
}




