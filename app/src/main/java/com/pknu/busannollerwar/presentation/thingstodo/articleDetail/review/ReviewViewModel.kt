package com.pknu.busannollerwar.presentation.thingstodo.articleDetail.review

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReviewViewModel @Inject constructor() : ViewModel() {
    private val _eventFlow = MutableSharedFlow<ReviewEvent>()
    val eventFlow get() = _eventFlow.asSharedFlow()

    private val _rateScore = MutableStateFlow<Int>(0)
    val rateScore: StateFlow<Int> = _rateScore.asStateFlow()

    private val _selectedImageUri = MutableStateFlow<String>("")
    val selectedImageUri: StateFlow<String> = _selectedImageUri.asStateFlow()

    private val _nowIndex = MutableStateFlow<Int>(0)
    val nowIndex = _nowIndex.asStateFlow()


    fun submitReview() {
        Log.d("test","submit!")
    }

    fun setImageUri(uri: String) {
        _selectedImageUri.value = uri
    }

    fun openGallery(idx: Int) {
        _nowIndex.value = idx
        event(ReviewEvent.OpenGallery(idx))
    }

    fun rateReview(idx: Int) {
        _rateScore.value = idx
    }

    private fun event(event: ReviewEvent) = viewModelScope.launch { _eventFlow.emit(event) }
}