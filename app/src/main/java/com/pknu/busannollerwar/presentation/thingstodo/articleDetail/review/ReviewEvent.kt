package com.pknu.busannollerwar.presentation.thingstodo.articleDetail.review

sealed class ReviewEvent {
    data class OpenGallery(val idx : Int) : ReviewEvent()
    data object SubmitReview : ReviewEvent()
}