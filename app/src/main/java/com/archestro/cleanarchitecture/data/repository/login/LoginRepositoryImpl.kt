package com.archestro.cleanarchitecture.data.repository.login

import com.archestro.cleanarchitecture.data.remote.apiService.LoginService
import com.archestro.cleanarchitecture.data.remote.model.login.LoginRequestModel
import com.archestro.cleanarchitecture.data.remote.model.login.LoginResponseModel
import com.archestro.cleanarchitecture.domain.repository.login.LoginRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val loginService: LoginService
) : LoginRepository {

    override suspend fun loginUser(loginRequestModel: LoginRequestModel): Flow<LoginResponseModel> {
        return flow {
            emit(loginService.login(loginRequestModel))
        }.flowOn(Dispatchers.IO)
    }

}