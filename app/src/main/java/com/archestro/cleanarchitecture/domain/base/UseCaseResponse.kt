package com.archestro.cleanarchitecture.domain.base

import com.archestro.cleanarchitecture.util.error.ErrorModel

interface UseCaseResponse<Type> {

    suspend fun onSuccess(result: Any)

    suspend fun onError(errorModel: ErrorModel?)
}