package com.pknu.busannollerwar.presentation.thingstodo.articleDetail.review

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pknu.busannollerwar.data.model.Article
import com.pknu.busannollerwar.presentation.thingstodo.articleDetail.ArticleDetailEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReviewViewModel @Inject constructor() : ViewModel() {
    private val _eventFlow = MutableSharedFlow<ReviewEvent>()
    val eventFlow get() = _eventFlow.asSharedFlow()

    fun openGallery(idx : Int) = event(ReviewEvent.OpenGallery(idx))

    private fun event(event: ReviewEvent) = viewModelScope.launch { _eventFlow.emit(event) }
}