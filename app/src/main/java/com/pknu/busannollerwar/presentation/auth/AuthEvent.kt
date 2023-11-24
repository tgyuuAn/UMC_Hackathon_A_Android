package com.pknu.busannollerwar.presentation.auth
sealed class AuthEvent {
    data object GoogleLogin : AuthEvent()
}