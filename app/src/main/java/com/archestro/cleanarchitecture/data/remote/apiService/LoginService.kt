package com.archestro.cleanarchitecture.data.remote.apiService

import com.archestro.cleanarchitecture.data.remote.model.login.LoginRequestModel
import com.archestro.cleanarchitecture.data.remote.model.login.LoginResponseModel
import retrofit2.http.POST

interface LoginService {

    @POST("/login")
    suspend fun login(loginRequestModel: LoginRequestModel) : LoginResponseModel

}