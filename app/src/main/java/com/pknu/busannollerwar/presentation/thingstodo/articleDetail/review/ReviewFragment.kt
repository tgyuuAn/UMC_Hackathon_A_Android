package com.pknu.busannollerwar.presentation.thingstodo.articleDetail.review

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.pknu.busannollerwar.databinding.FragmentReiviewBinding
import com.pknu.busannollerwar.presentation.thingstodo.articleDetail.ArticleDetailFragmentArgs
import com.pknu.busannollerwar.presentation.util.BaseFragment
import com.pknu.busannollerwar.presentation.util.repeatOnStarted
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ReviewFragment : BaseFragment<FragmentReiviewBinding, ReviewViewModel>(
    FragmentReiviewBinding::inflate
) {
    override val fragmentViewModel: ReviewViewModel by viewModels()
    val PICK_IMAGE = 1  // 아무 정수 값으로 설정

    private var selectedImageUri: Uri? = null
    private var nowIndex: Int = 0

    val reviewListAdapter: ReviewListAdapter by lazy {
        ReviewListAdapter(fragmentViewModel, requireContext())
    }
    val imageList = mutableListOf<Pair<Int, String>>(0 to "", 1 to "", 2 to "", 3 to "")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setBinding()
    }

    private fun setBinding() = binding.apply {
        val args: ArticleDetailFragmentArgs by navArgs()
        val nowArticle = args.article
        article = nowArticle

        viewModel = fragmentViewModel.apply {
            repeatOnStarted { eventFlow.collect { handleEvent(it) } }
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

    private fun handleEvent(event: ReviewEvent) = when (event) {
        is ReviewEvent.OpenGallery -> openGallery(event.idx)
    }

    private fun setRecyclerView() = binding.galleryRv.apply {
        adapter = reviewListAdapter
        layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        addItemDecoration(ReviewDecoration(requireContext()))
    }

    private fun openGallery(idx: Int) {
        nowIndex = idx
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, PICK_IMAGE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d("test", data?.data.toString())

        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK && data != null) {
            Log.d("test", nowIndex.toString())
            selectedImageUri = data.data!!
            imageList[nowIndex] = nowIndex to selectedImageUri.toString()
            reviewListAdapter.submitList(imageList.toList())
        }
    }
}