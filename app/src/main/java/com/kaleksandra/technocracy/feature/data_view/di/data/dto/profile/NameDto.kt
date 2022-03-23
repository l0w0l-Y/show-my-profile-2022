package com.kaleksandra.technocracy.feature.data_view.di.data.dto.profile

import com.google.gson.annotations.SerializedName

data class NameDto(
    @SerializedName("first")
    val first: String,

    @SerializedName("last")
    val last: String,

    @SerializedName("title")
    val title: String
)