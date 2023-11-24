package com.pknu.busannollerwar.presentation.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() : ViewModel() {

    private val _eventFlow = MutableSharedFlow<SplashEvent>()
    val eventFlow get() = _eventFlow.asSharedFlow()

    private val _progress = MutableStateFlow<Int>(0)
    val progress: StateFlow<Int> = _progress.asStateFlow()

    init {
        viewModelScope.launch {
            startProgress()
        }
    }

    private suspend fun startProgress() {
        while (_progress.value < 100) {
            _progress.value += 10
            delay(200L)
        }
        event(SplashEvent.SplashDone)
    }

    private fun event(event: SplashEvent) = viewModelScope.launch { _eventFlow.emit(event) }
}