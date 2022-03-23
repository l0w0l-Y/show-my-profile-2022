package com.kaleksandra.technocracy.feature.data_view.di.data.dto.profile

import com.google.gson.annotations.SerializedName

data class StreetDto(
    @SerializedName("name")
    val name: String,

    @SerializedName("number")
    val number: Int
)