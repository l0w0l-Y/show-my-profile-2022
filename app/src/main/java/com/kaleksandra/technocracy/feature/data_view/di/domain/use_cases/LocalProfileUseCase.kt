package com.kaleksandra.technocracy.feature.data_view.di.domain.use_cases

import android.util.Log
import com.kaleksandra.technocracy.feature.data_view.di.data.repositories.LocalProfileRepositoryImpl
import com.kaleksandra.technocracy.feature.data_view.di.domain.models.ProfileModel
import javax.inject.Inject

class LocalProfileUseCase @Inject constructor(
    private val repository: LocalProfileRepositoryImpl,
) {
    fun getLocalProfile(id: Int): ProfileModel? {
        return repository.getLocalProfile(id)
    }

    fun insertLocalProfile(id: Int, model: ProfileModel) {
        return repository.insertLocalProfile(id, model)
    }
}