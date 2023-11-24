package com.pknu.busannollerwar.presentation.thingstodo.articleDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pknu.busannollerwar.data.model.Article
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleDetailViewModel @Inject constructor() : ViewModel() {
    private val _eventFlow = MutableSharedFlow<ArticleDetailEvent>()
    val eventFlow get() = _eventFlow.asSharedFlow()

    fun navigateToReview(article: Article) = event(ArticleDetailEvent.NavigateToReview(article))

    private fun event(event: ArticleDetailEvent) = viewModelScope.launch { _eventFlow.emit(event) }
}