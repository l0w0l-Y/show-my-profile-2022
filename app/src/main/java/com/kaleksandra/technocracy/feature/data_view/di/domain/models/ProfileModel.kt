package com.kaleksandra.technocracy.feature.data_view.di.domain.models

data class ProfileModel(
    val dob: String,
    val location: LocationModel,
    val name: NameModel,
    val phone: String,
    val picture: String
)
