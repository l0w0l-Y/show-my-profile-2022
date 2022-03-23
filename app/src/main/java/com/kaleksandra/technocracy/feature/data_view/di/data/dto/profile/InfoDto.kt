package com.kaleksandra.technocracy.feature.data_view.di.data.dto.profile

import com.google.gson.annotations.SerializedName

data class InfoDto(
    @SerializedName("page")
    val page: Int,

    @SerializedName("results")
    val results: Int,

    @SerializedName("seed")
    val seed: String,

    @SerializedName("version")
    val version: String
)