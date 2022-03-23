package com.kaleksandra.technocracy.feature.data_view.di.data.dto.profile

import com.google.gson.annotations.SerializedName

data class ProfileDto(
    @SerializedName("info")
    val info: InfoDto,

    @SerializedName("results")
    val results: List<ResultDto>
)