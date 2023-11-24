package com.pknu.busannollerwar.presentation.home

sealed class HomeEvent {
    data class NavigateToContents(val contents: Contents): HomeEvent()
}