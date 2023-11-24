package com.pknu.busannollerwar.presentation.thingstodo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pknu.busannollerwar.databinding.ItemThingsToDoImageCardBinding

class ThingsToDoViewHolder(val binding: ItemThingsToDoImageCardBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind() {

    }
}

class ThingsToDoListAdapter : ListAdapter<Int, ThingsToDoViewHolder>(object :
    DiffUtil.ItemCallback<Int>() {
    override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean {
        return oldItem == newItem
    }
}) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThingsToDoViewHolder {
        val binding =
            ItemThingsToDoImageCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ThingsToDoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ThingsToDoViewHolder, position: Int) {
        holder.bind()
    }
}




