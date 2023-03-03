package com.archestro.cleanarchitecture.domain.repository.login

import com.archestro.cleanarchitecture.data.remote.model.login.LoginRequestModel
import com.archestro.cleanarchitecture.data.remote.model.login.LoginResponseModel
import kotlinx.coroutines.flow.Flow

interface LoginRepository {

    suspend fun loginUser(loginRequestModel: LoginRequestModel) : Flow<LoginResponseModel>
}