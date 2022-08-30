package com.sreedevi.devapp.data.datasources.login

import com.qaptive.core.models.APIResult
import com.sreedevi.devapp.data.repositories.LoginRepository
import com.sreedevi.devapp.model.LoginRequest
import com.sreedevi.devapp.model.LoginResponse
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class LoginDataSource @Inject constructor(private val remote: LoginDataSource.Remote) :LoginRepository {

    interface Remote{
        fun login(request: LoginRequest): Single<APIResult<LoginResponse>>
    }

    override fun login(request: LoginRequest): Single<APIResult<LoginResponse>> {
        return remote.login(request)
    }
}