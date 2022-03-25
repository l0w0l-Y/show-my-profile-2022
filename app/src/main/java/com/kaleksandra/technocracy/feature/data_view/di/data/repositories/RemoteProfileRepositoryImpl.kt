package com.kaleksandra.technocracy.feature.data_view.di.data.repositories

import com.kaleksandra.technocracy.core.ResponseResult
import com.kaleksandra.technocracy.feature.data_view.di.data.ProfileApiService
import com.kaleksandra.technocracy.feature.data_view.di.data.dto.profile.toProfileModel
import com.kaleksandra.technocracy.feature.data_view.di.domain.models.ProfileModel
import com.kaleksandra.technocracy.feature.data_view.di.domain.repositories.RemoteProfileRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class RemoteProfileRepositoryImpl @Inject constructor(
    private val apiService: ProfileApiService
) :
    RemoteProfileRepository {

    override suspend fun getProfile(): ResponseResult<ProfileModel> {
        return try {
            ResponseResult.Success(apiService.getProfile().body()!!.toProfileModel())
        } catch (e: HttpException) {
            ResponseResult.Error(e.code(), e.message())
        } catch (e: IOException) {
            ResponseResult.Error(500, e.message.toString())
        }
    }
}