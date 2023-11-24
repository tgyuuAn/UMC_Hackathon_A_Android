package com.pknu.busannollerwar.presentation.thingstodo.articleDetail.review

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.pknu.busannollerwar.R
import com.pknu.busannollerwar.databinding.FragmentReiviewBinding
import com.pknu.busannollerwar.presentation.thingstodo.articleDetail.ArticleDetailFragmentArgs
import com.pknu.busannollerwar.presentation.util.BaseFragment
import com.pknu.busannollerwar.presentation.util.repeatOnStarted
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ReviewFragment :BaseFragment<FragmentReiviewBinding, ReviewViewModel>(
    FragmentReiviewBinding::inflate
) {
    override val fragmentViewModel: ReviewViewModel by viewModels()
    val PICK_IMAGE = 1  // 아무 정수 값으로 설정

    val reviewListAdapter: ReviewListAdapter by lazy {
        ReviewListAdapter(fragmentViewModel, requireContext())
    }

    val imageList = mutableListOf<Pair<Int, String>>(0 to "", 1 to "", 2 to "", 3 to "")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setBinding()

        binding.pictureIv.setOnClickListener {
            openGallery()
        }
    }

    private fun setBinding() = binding.apply {
        val args: ArticleDetailFragmentArgs by navArgs()
        val nowArticle = args.article
        article = nowArticle

        viewModel = fragmentViewModel.apply {
            repeatOnStarted { eventFlow.collect { handleEvent(it) } }
            repeatOnStarted { rateScore.collect { handleRate(it) } }
            repeatOnStarted { selectedImageUri.collect { handleImageUri(it) } }
        }
        setRecyclerView()
        reviewListAdapter.submitList(imageList)

        edtReview.setOnEditorActionListener { textView, action, event ->
            var handled = false

            if (action == EditorInfo.IME_ACTION_DONE) {
                val inputMethodManager =
                    requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(edtReview.windowToken, 0)
                handled = true
            }

            handled
        }
    }

    private fun handleImageUri(uri: String) {
        Log.d("test", "이미지 URI :" + uri)
        Log.d("test", imageList.toString())
        imageList[fragmentViewModel.nowIndex.value] = fragmentViewModel.nowIndex.value to uri
        reviewListAdapter.submitList(imageList.toList())
    }

    private fun handleEvent(event: ReviewEvent) = when (event) {
        is ReviewEvent.OpenGallery -> openGallery()
        is ReviewEvent.SubmitReview -> {
            Toast.makeText(requireContext(), "리뷰 작성을 완료하였습니다!", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.thingsToDoFragment)
        }
    }

    private fun handleRate(score: Int) {
        when (score) {
            1 -> binding.apply {
                star1Iv.setImageResource(R.drawable.star_yellow)
                star2Iv.setImageResource(R.drawable.star_gray)
                star3Iv.setImageResource(R.drawable.star_gray)
                star4Iv.setImageResource(R.drawable.star_gray)
                star5Iv.setImageResource(R.drawable.star_gray)
            }

            2 -> binding.apply {
                star1Iv.setImageResource(R.drawable.star_yellow)
                star2Iv.setImageResource(R.drawable.star_yellow)
                star3Iv.setImageResource(R.drawable.star_gray)
                star4Iv.setImageResource(R.drawable.star_gray)
                star5Iv.setImageResource(R.drawable.star_gray)
            }

            3 -> binding.apply {
                star1Iv.setImageResource(R.drawable.star_yellow)
                star2Iv.setImageResource(R.drawable.star_yellow)
                star3Iv.setImageResource(R.drawable.star_yellow)
                star4Iv.setImageResource(R.drawable.star_gray)
                star5Iv.setImageResource(R.drawable.star_gray)
            }

            4 -> binding.apply {
                star1Iv.setImageResource(R.drawable.star_yellow)
                star2Iv.setImageResource(R.drawable.star_yellow)
                star3Iv.setImageResource(R.drawable.star_yellow)
                star4Iv.setImageResource(R.drawable.star_yellow)
                star5Iv.setImageResource(R.drawable.star_gray)
            }

            5 -> binding.apply {
                star1Iv.setImageResource(R.drawable.star_yellow)
                star2Iv.setImageResource(R.drawable.star_yellow)
                star3Iv.setImageResource(R.drawable.star_yellow)
                star4Iv.setImageResource(R.drawable.star_yellow)
                star5Iv.setImageResource(R.drawable.star_yellow)
            }

            else -> binding.apply {
                star1Iv.setImageResource(R.drawable.star_gray)
                star2Iv.setImageResource(R.drawable.star_gray)
                star3Iv.setImageResource(R.drawable.star_gray)
                star4Iv.setImageResource(R.drawable.star_gray)
                star5Iv.setImageResource(R.drawable.star_gray)
            }
        }
    }


    private fun setRecyclerView() = binding.galleryRv.apply {
        adapter = reviewListAdapter
        layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        addItemDecoration(ReviewDecoration(requireContext()))
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, PICK_IMAGE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d("test", "결과" + data?.data.toString())

        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK && data != null) {
            Log.d("test", fragmentViewModel.nowIndex.toString())
            fragmentViewModel.setImageUri(data.data!!.toString())
        }
    }
}