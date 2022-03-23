package com.kaleksandra.technocracy.feature.data_view.di.data.dto.profile

import com.google.gson.annotations.SerializedName

data class TimezoneDto(
    @SerializedName("description")
    val description: String,

    @SerializedName("offset")
    val offset: String
)