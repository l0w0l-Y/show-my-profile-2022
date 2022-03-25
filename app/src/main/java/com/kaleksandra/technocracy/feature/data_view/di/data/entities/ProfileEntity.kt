package com.kaleksandra.technocracy.feature.data_view.di.data.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kaleksandra.technocracy.feature.data_view.di.domain.models.*

@Entity
data class ProfileEntity(
    @PrimaryKey val id: Int,
    @NonNull @ColumnInfo(name = "name") val name: String,
    @NonNull @ColumnInfo(name = "surname") val surname: String,
    @NonNull @ColumnInfo(name = "date") val date: String,
    @NonNull @ColumnInfo(name = "phone") val phone: String,
    @NonNull @ColumnInfo(name = "location_country") val locationCountry: String,
    @NonNull @ColumnInfo(name = "location_city") val locationCity: String,
    @NonNull @ColumnInfo(name = "location_street_name") val locationStreetName: String,
    @NonNull @ColumnInfo(name = "location_street_number") val locationStreetNumber: Int,
    @NonNull @ColumnInfo(name = "coordinates_latitude") val coordinatesLatitude: String,
    @NonNull @ColumnInfo(name = "coordinates_longitude") val coordinatesLongitude: String,
    @NonNull @ColumnInfo(name = "picture_large") val pictureLarge: String
)

fun ProfileEntity.toProfileModel(): ProfileModel {
    val profile: ProfileModel?
    profile = ProfileModel(
        this.date,
        LocationModel(
            this.locationCity,
            CoordinatesModel(
                this.coordinatesLatitude,
                this.locationCountry
            ),
            this.locationCountry,
            StreetModel(
                this.locationStreetName,
                this.locationStreetNumber
            )
        ),
        NameModel(this.name, this.surname),
        this.phone,
        this.pictureLarge
    )
    return profile
}