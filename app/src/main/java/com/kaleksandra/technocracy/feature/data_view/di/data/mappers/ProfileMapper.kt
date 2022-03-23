package com.kaleksandra.technocracy.feature.data_view.di.data.mappers

import com.kaleksandra.technocracy.feature.data_view.di.data.dto.profile.ProfileDto
import com.kaleksandra.technocracy.feature.data_view.di.data.entities.ProfileEntity
import com.kaleksandra.technocracy.feature.data_view.di.domain.models.*

object ProfileMapper {
    fun transform(profileEntity: ProfileEntity?): ProfileModel? {
        var profile: ProfileModel? = null
        if (profileEntity != null) {
            profile = ProfileModel(
                profileEntity.date,
                LocationModel(
                    profileEntity.locationCity,
                    CoordinatesModel(
                        profileEntity.coordinatesLatitude,
                        profileEntity.locationCountry
                    ),
                    profileEntity.locationCountry,
                    StreetModel(
                        profileEntity.locationStreetName,
                        profileEntity.locationStreetNumber
                    )
                ),
                NameModel(profileEntity.name, profileEntity.surname),
                profileEntity.phone,
                profileEntity.pictureLarge
            )
        }
        return profile
    }

    fun transform(profileDto: ProfileDto): ProfileModel {
        val profile: ProfileModel
        val profileResult = profileDto.results[0]
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

    fun transform(id: Int, profileModel: ProfileModel): ProfileEntity {
        return ProfileEntity(
            id = id,
            name = profileModel.name.first,
            surname = profileModel.name.last,
            date = profileModel.dob,
            phone = profileModel.phone,
            locationCity = profileModel.location.city,
            locationCountry = profileModel.location.country,
            locationStreetName = profileModel.location.street.name,
            locationStreetNumber = profileModel.location.street.number,
            coordinatesLatitude = profileModel.location.coordinates.latitude,
            coordinatesLongitude = profileModel.location.coordinates.longitude,
            pictureLarge = profileModel.picture
        )
    }
}