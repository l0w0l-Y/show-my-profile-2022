package com.kaleksandra.technocracy.feature.data_view.di.data.dto.profile

import com.google.gson.annotations.SerializedName
import com.kaleksandra.technocracy.feature.data_view.di.domain.models.*

data class ProfileDto(
    @SerializedName("info")
    val info: InfoDto,

    @SerializedName("results")
    val results: List<ResultDto>
)

fun ProfileDto.toProfileModel(): ProfileModel {
    val profile: ProfileModel
    val profileResult = this.results[0]
    profile = ProfileModel(
        profileResult.dob.date,
        LocationModel(
            profileResult.location.city,
            CoordinatesModel(
                profileResult.location.coordinates.latitude,
                profileResult.location.coordinates.longitude
            ),
            profileResult.location.country,
            StreetModel(
                profileResult.location.street.name,
                profileResult.location.street.number
            )
        ),
        NameModel(profileResult.name.first, profileResult.name.last),
        profileResult.phone,
        profileResult.picture.large
    )
    return profile
}