package com.kaleksandra.technocracy.feature.data_view.di.data.dto.profile

import com.google.gson.annotations.SerializedName

data class ResultDto(
    @SerializedName("dob")
    val dob: DobDto,

    @SerializedName("location")
    val location: LocationDto,

    @SerializedName("name")
    val name: NameDto,

    @SerializedName("phone")
    val phone: String,

    @SerializedName("picture")
    val picture: PictureDto
)