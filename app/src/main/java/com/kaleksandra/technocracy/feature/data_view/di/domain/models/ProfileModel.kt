package com.kaleksandra.technocracy.feature.data_view.di.domain.models

import com.kaleksandra.technocracy.feature.data_view.di.data.entities.ProfileEntity

data class ProfileModel(
    val dob: String,
    val location: LocationModel,
    val name: NameModel,
    val phone: String,
    val picture: String
)

fun ProfileModel.toProfileEntity(id: Int): ProfileEntity {
    return ProfileEntity(
        id = id,
        name = this.name.first,
        surname = this.name.last,
        date = this.dob,
        phone = this.phone,
        locationCity = this.location.city,
        locationCountry = this.location.country,
        locationStreetName = this.location.street.name,
        locationStreetNumber = this.location.street.number,
        coordinatesLatitude = this.location.coordinates.latitude,
        coordinatesLongitude = this.location.coordinates.longitude,
        pictureLarge = this.picture
    )
}
