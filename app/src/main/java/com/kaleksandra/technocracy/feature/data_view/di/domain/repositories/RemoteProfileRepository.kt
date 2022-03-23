package com.kaleksandra.technocracy.feature.data_view.di.domain.repositories

import com.kaleksandra.technocracy.core.ResponseResult
import com.kaleksandra.technocracy.feature.data_view.di.domain.models.ProfileModel

interface RemoteProfileRepository {
    suspend fun getProfile(): ResponseResult<ProfileModel>
}