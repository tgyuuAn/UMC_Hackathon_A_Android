package com.pknu.busannollerwar.presentation.thingstodo.review

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pknu.busannollerwar.databinding.ItemGalleryBinding

class ReviewViewHolder(val binding: ItemGalleryBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind() {

    }
}

class ReviewListAdapter : ListAdapter<Int, ReviewViewHolder>(object :
    DiffUtil.ItemCallback<Int>() {

    override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean {
        return oldItem == newItem
    }
}) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val binding = ItemGalleryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ReviewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        holder.bind()
    }
}




