package com.kaleksandra.technocracy.feature.data_view.di.data.dto.profile

import com.google.gson.annotations.SerializedName

data class DobDto(
    @SerializedName("age")
    val age: Int,

    @SerializedName("date")
    val date: String
)