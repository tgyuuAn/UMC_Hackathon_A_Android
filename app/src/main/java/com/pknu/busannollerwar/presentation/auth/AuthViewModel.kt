package com.pknu.busannollerwar.presentation.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pknu.busannollerwar.presentation.home.HomeEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel()
class AuthViewModel @Inject constructor() : ViewModel() {
    private val _eventFlow = MutableSharedFlow<AuthEvent>()
    val eventFlow get() = _eventFlow.asSharedFlow()

    fun googleLogin() = event(AuthEvent.GoogleLogin)

    private fun event(event: AuthEvent) = viewModelScope.launch { _eventFlow.emit(event) }
}