package com.kaleksandra.technocracy.feature.data_view.di.data.dto.profile

data class LocationDto(
    val city: String,
    val coordinates: CoordinatesDto,
    val country: String,
    val postcode: String,
    val state: String,
    val street: StreetDto,
    val timezone: TimezoneDto
)