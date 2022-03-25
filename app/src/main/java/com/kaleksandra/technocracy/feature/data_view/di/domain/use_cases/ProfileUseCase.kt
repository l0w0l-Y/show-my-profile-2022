package com.kaleksandra.technocracy.feature.data_view.di.domain.use_cases

import com.kaleksandra.technocracy.core.ResponseResult
import com.kaleksandra.technocracy.feature.data_view.di.data.repositories.LocalProfileRepositoryImpl
import com.kaleksandra.technocracy.feature.data_view.di.data.repositories.RemoteProfileRepositoryImpl
import com.kaleksandra.technocracy.feature.data_view.di.domain.models.ProfileModel
import javax.inject.Inject

class ProfileUseCase @Inject constructor(
    private val localRepository: LocalProfileRepositoryImpl,
    private val remoteRepository: RemoteProfileRepositoryImpl
) {
    suspend fun getLocalProfile(id: Int): ProfileModel {
        return localRepository.getLocalProfile(id)
    }

    suspend fun insertLocalProfile(id: Int, model: ProfileModel) {
        return localRepository.insertLocalProfile(id, model)
    }

    suspend fun getRemoteProfile(): ResponseResult<ProfileModel> {
        return remoteRepository.getProfile()
    }
}