package com.archestro.cleanarchitecture.domain.usecase.login

import com.archestro.cleanarchitecture.data.remote.model.login.LoginRequestModel
import com.archestro.cleanarchitecture.data.remote.model.login.LoginResponseModel
import com.archestro.cleanarchitecture.domain.base.BaseUseCase
import com.archestro.cleanarchitecture.domain.repository.login.LoginRepository
import com.archestro.cleanarchitecture.util.error.ApiErrorHandle
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository,
    apiErrorHandle: ApiErrorHandle
) : BaseUseCase<LoginResponseModel>(apiErrorHandle){
    override suspend fun run(parameter: Any?): Flow<Any> {
        return loginRepository.loginUser(parameter as LoginRequestModel)
    }

}