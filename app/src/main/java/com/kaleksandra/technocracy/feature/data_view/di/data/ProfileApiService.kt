package com.kaleksandra.technocracy.feature.data_view.di.data

import com.kaleksandra.technocracy.feature.data_view.di.data.dto.profile.ProfileDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface ProfileApiService {
    /**
     * Gets a profile with the given characteristics: picture, name, dob, phone, location
     */
    @Headers("Accept: application/json", "Content-Type: application/json")
    @GET(".?inc=picture,name,dob,phone,location")
    suspend fun getProfile(): Response<ProfileDto>
}