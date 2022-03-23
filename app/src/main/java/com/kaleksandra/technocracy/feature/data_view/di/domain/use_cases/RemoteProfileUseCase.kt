package com.kaleksandra.technocracy.feature.data_view.di.domain.use_cases

import com.kaleksandra.technocracy.core.ResponseResult
import com.kaleksandra.technocracy.feature.data_view.di.data.repositories.RemoteProfileRepositoryImpl
import com.kaleksandra.technocracy.feature.data_view.di.domain.models.ProfileModel
import javax.inject.Inject

class RemoteProfileUseCase @Inject constructor(private val repository: RemoteProfileRepositoryImpl) {
    suspend fun getProfile(): ResponseResult<ProfileModel> {
        return repository.getProfile()
    }
}