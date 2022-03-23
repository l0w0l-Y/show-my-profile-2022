package com.kaleksandra.technocracy.feature.data_view.di.data.repositories

import com.kaleksandra.technocracy.feature.data_view.di.data.db.dao.ProfileDao
import com.kaleksandra.technocracy.feature.data_view.di.data.mappers.ProfileMapper
import com.kaleksandra.technocracy.feature.data_view.di.domain.models.ProfileModel
import javax.inject.Inject

class LocalProfileRepositoryImpl @Inject constructor(private val profileDao: ProfileDao) {
    fun getLocalProfile(id: Int): ProfileModel? {
        return ProfileMapper.transform(profileDao.getProfile(id))
    }

    fun insertLocalProfile(id: Int, model: ProfileModel) {
        return profileDao.insertProfile(ProfileMapper.transform(id, model))
    }
}
