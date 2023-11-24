package com.pknu.busannollerwar.presentation.home.contents

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContentsViewModel @Inject constructor() : ViewModel() {
    private val _eventFlow = MutableSharedFlow<ContentsEvent>()
    val eventFlow get() = _eventFlow.asSharedFlow()

    private fun event(event: ContentsEvent) = viewModelScope.launch { _eventFlow.emit(event) }
}