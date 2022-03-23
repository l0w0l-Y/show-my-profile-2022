package com.kaleksandra.technocracy.feature.data_view.di.data.repositories

import com.kaleksandra.technocracy.core.ResponseResult
import com.kaleksandra.technocracy.feature.data_view.di.data.ProfileApiService
import com.kaleksandra.technocracy.feature.data_view.di.data.mappers.ProfileMapper
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
            ResponseResult.Success(ProfileMapper.transform(apiService.getProfile().body()!!))
        } catch (e: HttpException) {
            ResponseResult.Error(e.code(), e.message())
        } catch (e: IOException) {
            ResponseResult.Error(500, e.message.toString())
        }
    }
}