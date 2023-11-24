package com.pknu.busannollerwar.presentation.thingstodo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pknu.busannollerwar.data.model.Article
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ThingsToDoViewModel @Inject constructor() : ViewModel() {
    private val _eventFlow = MutableSharedFlow<ThingsToDoEvent>()
    val eventFlow get() = _eventFlow.asSharedFlow()
    fun navigateToArticleDetail(article : Article) = event(ThingsToDoEvent.NavigateToArticleDetail(article))
    private fun event(event: ThingsToDoEvent) = viewModelScope.launch { _eventFlow.emit(event) }
}