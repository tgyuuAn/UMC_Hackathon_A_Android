package com.pknu.busannollerwar.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Article(
    @SerialName("board_id") val boardID: Int,
    val title: String,
    val content: String,
    @SerialName("created_at") val createdAt: String,
    @SerialName("modified_at") val modifiedAt: String,
    val hits: Int,
)