package com.pknu.busannollerwar.presentation.thingstodo.review

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.pknu.busannollerwar.databinding.FragmentReiviewBinding
import com.pknu.busannollerwar.presentation.thingstodo.articleDetail.ArticleDetailFragmentArgs
import com.pknu.busannollerwar.presentation.util.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ReviewFragment : BaseFragment<FragmentReiviewBinding, ReviewViewModel>(
    FragmentReiviewBinding::inflate
) {
    override val fragmentViewModel: ReviewViewModel by viewModels()
    val PICK_IMAGE = 1  // 아무 정수 값으로 설정

    val reviewListAdapter: ReviewListAdapter by lazy { ReviewListAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        setBinding()
    }

    private fun setBinding() = binding.apply {
        val args: ArticleDetailFragmentArgs by navArgs()
        val nowArticle = args.article
        article = nowArticle
    }

    private fun setRecyclerView() = binding.galleryRv.apply {
        adapter = reviewListAdapter
        layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        setOnClickListener() {
            openGallery()
        }
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, PICK_IMAGE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK && data != null) {
            // 이미지를 선택한 경우 처리
            val selectedImageUri: Uri = data.data!!
            loadImageIntoImageView(binding.pictureIv, selectedImageUri)
            // 여기에서 선택한 이미지를 사용하거나 처리할 수 있습니다.
        }
    }

    private fun loadImageIntoImageView(imageView: ImageView, imageUri: Uri) {
        Glide.with(requireContext())
            .load(imageUri)
            .into(imageView)
    }
}