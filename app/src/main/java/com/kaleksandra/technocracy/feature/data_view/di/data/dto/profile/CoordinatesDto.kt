package com.kaleksandra.technocracy.feature.data_view.di.data.dto.profile

import com.google.gson.annotations.SerializedName

data class CoordinatesDto(
    @SerializedName("latitude")
    val latitude: String,

    @SerializedName("longitude")
    val longitude: String
)