package com.pknu.busannollerwar.presentation.thingstodo.articleDetail.review

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pknu.busannollerwar.databinding.ItemArticleReviewImageBinding

class ReviewViewHolder(
    private val fragmentViewModel: ReviewViewModel,
    private val binding: ItemArticleReviewImageBinding,
    private val context : Context,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(idx: Int, item: String) {
        binding.apply {
            viewModel = fragmentViewModel
            index = idx
            Log.d("test",idx.toString())

            if (item != "") {
                Log.d("test", "성공")
                ivItemImage.visibility = View.VISIBLE
                tvPlus.visibility = View.GONE

                Glide.with(context).load(item)
                    .into(ivItemImage)
            } else {
                ivItemImage.visibility = View.GONE
                tvPlus.visibility = View.VISIBLE
            }
        }
    }
}

class ReviewListAdapter(
    private val viewModel: ReviewViewModel,
    private val context : Context
) :
    ListAdapter<Pair<Int,String>, ReviewViewHolder>(object :
        DiffUtil.ItemCallback<Pair<Int,String>>() {

        override fun areItemsTheSame(oldItem: Pair<Int,String>, newItem: Pair<Int,String>): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Pair<Int,String>, newItem: Pair<Int,String>): Boolean {
            return oldItem == newItem
        }
    }) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val binding = ItemArticleReviewImageBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        Log.d("test","호출 성공")
        return ReviewViewHolder(viewModel, binding, context)
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        Log.d("test","bind 성공")
        holder.bind(getItem(position).first, getItem(position).second)
    }
}




