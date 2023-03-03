package com.archestro.cleanarchitecture.presentation

import com.archestro.cleanarchitecture.base.BaseViewModel
import com.archestro.cleanarchitecture.base.Outcome
import com.archestro.cleanarchitecture.data.remote.model.login.LoginRequestModel
import com.archestro.cleanarchitecture.data.remote.model.login.LoginResponseModel
import com.archestro.cleanarchitecture.domain.base.UseCaseResponse
import com.archestro.cleanarchitecture.domain.usecase.login.LoginUseCase
import com.archestro.cleanarchitecture.util.error.ErrorModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : BaseViewModel() {

    private val _loginResponse = MutableStateFlow<LoginResponseModel?>(null)
    val loginResponse: StateFlow<LoginResponseModel?> = _loginResponse

    fun loginUser(loginRequestModel: LoginRequestModel) {
        outcomeLiveData.value = Outcome.Start<Any>()
        loginUseCase.invoke(
            scope = scope,
            parameter = loginRequestModel,
            onResult = object : UseCaseResponse<LoginResponseModel> {

                override suspend fun onSuccess(result: Any) {
                    outcomeLiveData.value = Outcome.Success(result)
                    _loginResponse.value = result as LoginResponseModel
                }

                override suspend fun onError(errorModel: ErrorModel?) {
                    outcomeLiveData.value = Outcome.Failure<Any>(errorModel)
                }
            }
        )
    }
}