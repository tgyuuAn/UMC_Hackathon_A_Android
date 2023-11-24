package com.pknu.busannollerwar.presentation.thingstodo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pknu.busannollerwar.data.model.Article
import com.pknu.busannollerwar.databinding.ItemThingsToDoImageCardBinding

class ThingsToDoViewHolder(
    private val binding: ItemThingsToDoImageCardBinding,
    private val fragmentViewModel: ThingsToDoViewModel,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item : Article) {
        binding.apply {
            article = item
            viewModel = fragmentViewModel
        }
    }
}

class ThingsToDoListAdapter(private val viewModel: ThingsToDoViewModel) :
    ListAdapter<Article, ThingsToDoViewHolder>(object :
        DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean = oldItem == newItem
        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean = oldItem == newItem
    }) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThingsToDoViewHolder {
        val binding = ItemThingsToDoImageCardBinding.inflate(
                LayoutInflater.from(parent.context), parent,false)
        return ThingsToDoViewHolder(binding, viewModel)
    }

    override fun onBindViewHolder(holder: ThingsToDoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}




