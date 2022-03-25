package com.kaleksandra.technocracy

import com.kaleksandra.technocracy.feature.data_view.di.data.entities.ProfileEntity
import com.kaleksandra.technocracy.feature.data_view.di.domain.models.*

object TestUtil {

    fun createOneProfile(id: Int): ProfileEntity {
        return ProfileModel(
            "1984-10-01T23:32:51.819Z",
            location = LocationModel(
                "Kazan",
                CoordinatesModel("10.324", "20.4031"),
                "Russia",
                StreetModel("Chekhova", 10)
            ),
            name = NameModel("Ivan", "Petrov"),
            phone = "79000310422",
            picture = "https://randomuser.me/api/portraits/men/41.jpg"
        ).toProfileEntity(id)
    }

    fun changeProfileName(entity: ProfileEntity, name: String): ProfileEntity {
        return ProfileEntity(
            entity.id,
            name,
            entity.surname,
            entity.date,
            entity.phone,
            entity.locationCountry,
            entity.locationCity,
            entity.locationStreetName,
            entity.locationStreetNumber,
            entity.coordinatesLatitude,
            entity.coordinatesLongitude,
            entity.pictureLarge
        )
    }
}