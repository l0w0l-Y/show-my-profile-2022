package com.kaleksandra.technocracy

import com.kaleksandra.technocracy.core.ResponseResult
import com.kaleksandra.technocracy.feature.data_view.di.domain.models.*
import com.kaleksandra.technocracy.feature.data_view.di.domain.repositories.RemoteProfileRepository
import javax.inject.Inject

class RemoteProfileRepositoryImpl @Inject constructor() :
    RemoteProfileRepository {

    override suspend fun getProfile() = ResponseResult.Success(
        ProfileModel(
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
        )
    )
}