package com.pknu.busannollerwar.presentation.thingstodo.articleDetail

import androidx.lifecycle.ViewModel
import com.pknu.busannollerwar.presentation.thingstodo.ThingsToDoEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

@HiltViewModel
class ArticleDetailViewModel @Inject constructor() : ViewModel() {
    private val _eventFlow = MutableSharedFlow<ArticleDetailEvent>()
    val eventFlow get() = _eventFlow.asSharedFlow()
}