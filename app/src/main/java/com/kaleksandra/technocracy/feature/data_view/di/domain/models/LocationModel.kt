package com.kaleksandra.technocracy.feature.data_view.di.domain.models

data class LocationModel(
    val city: String,
    val coordinates: CoordinatesModel,
    val country: String,
    val street: StreetModel,
)