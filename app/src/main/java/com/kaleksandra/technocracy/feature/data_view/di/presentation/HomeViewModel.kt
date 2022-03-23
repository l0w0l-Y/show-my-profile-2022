package com.kaleksandra.technocracy.feature.data_view.di.presentation

import android.graphics.Color
import androidx.lifecycle.*
import com.kaleksandra.technocracy.core.ResponseResult
import com.kaleksandra.technocracy.feature.data_view.di.domain.models.ProfileModel
import com.kaleksandra.technocracy.feature.data_view.di.domain.use_cases.LocalProfileUseCase
import com.kaleksandra.technocracy.feature.data_view.di.domain.use_cases.RemoteProfileUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val remoteProfileUseCase: RemoteProfileUseCase,
    private val localProfileUseCase: LocalProfileUseCase
) : ViewModel() {

    private var _profile = MutableLiveData<ResponseResult<ProfileModel?>>()
    val profile: LiveData<ResponseResult<ProfileModel?>>
        get() = _profile

    private var _color: Int? = randomColor()
    val color: Int?
        get() = _color

    init {
        getLocalProfile(0)
    }

    fun getRemoteProfile() {
        viewModelScope.launch(Dispatchers.IO) {
            _profile.postValue(ResponseResult.Loading(Unit))

            when (val response = remoteProfileUseCase.getProfile()) {
                is ResponseResult.Success -> {
                    insertLocalProfile(0, response.body)
                    _color = randomColor()
                    _profile.postValue(response)
                }
                is ResponseResult.Error -> {
                    _profile.postValue(response)
                }
                else -> {}
            }
        }
    }

    private fun getLocalProfile(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _profile.postValue(ResponseResult.Loading(Unit))

            val profile = localProfileUseCase.getLocalProfile(id)
            _profile.postValue(ResponseResult.Success(profile))
        }
    }

    private fun insertLocalProfile(id: Int, entity: ProfileModel) =
        viewModelScope.launch(Dispatchers.IO) {
            localProfileUseCase.insertLocalProfile(id, entity)
        }

    private fun randomColor(): Int {
        val rnd = Random()
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
    }

}