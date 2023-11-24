package com.pknu.busannollerwar.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UpLoadImage(
    @SerialName("image_id") val imageId: Int,
    @SerialName("board_id") val boardId: Int,
    @SerialName("comment_id") val commentId: Int,
    @SerialName("file_name") val fileName: String,
    @SerialName("file_path") val filePath: String,
    @SerialName("image_data") val ImageData: String,
)