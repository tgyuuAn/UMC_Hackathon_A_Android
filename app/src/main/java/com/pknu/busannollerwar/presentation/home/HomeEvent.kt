package com.pknu.busannollerwar.presentation.home

import com.pknu.busannollerwar.presentation.home.contents.Contents

sealed class HomeEvent {
    data class NavigateToContents(val contents: Contents): HomeEvent()
}