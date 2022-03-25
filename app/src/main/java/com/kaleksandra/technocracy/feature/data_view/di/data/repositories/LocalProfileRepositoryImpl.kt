package com.kaleksandra.technocracy.feature.data_view.di.data.repositories

import com.kaleksandra.technocracy.feature.data_view.di.data.db.dao.ProfileDao
import com.kaleksandra.technocracy.feature.data_view.di.data.entities.toProfileModel
import com.kaleksandra.technocracy.feature.data_view.di.domain.models.ProfileModel
import com.kaleksandra.technocracy.feature.data_view.di.domain.models.toProfileEntity
import javax.inject.Inject

class LocalProfileRepositoryImpl @Inject constructor(private val profileDao: ProfileDao) {
    suspend fun getLocalProfile(id: Int): ProfileModel {
        return profileDao.getProfile(id).toProfileModel()
    }

    suspend fun insertLocalProfile(id: Int, model: ProfileModel) {
        return profileDao.insertProfile(model.toProfileEntity(id))
    }
}
