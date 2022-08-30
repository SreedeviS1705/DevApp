package com.sreedevi.devapp.data.repositories

import com.qaptive.core.models.APIResult
import com.sreedevi.devapp.model.LoginRequest
import com.sreedevi.devapp.model.LoginResponse
import io.reactivex.rxjava3.core.Single

interface LoginRepository {
    fun login(request: LoginRequest): Single<APIResult<LoginResponse>>
}