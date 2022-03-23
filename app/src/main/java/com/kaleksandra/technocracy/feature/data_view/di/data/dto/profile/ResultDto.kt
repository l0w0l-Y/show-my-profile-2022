package com.kaleksandra.technocracy.feature.data_view.di.data.dto.profile

data class ResultDto(
    val dob: DobDto,
    val location: LocationDto,
    val name: NameDto,
    val phone: String,
    val picture: PictureDto
)