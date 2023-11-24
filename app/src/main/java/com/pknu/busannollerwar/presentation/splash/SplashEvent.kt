package com.pknu.busannollerwar.presentation.splash
    sealed class SplashEvent {
        data object TimerDone : SplashEvent()
    }