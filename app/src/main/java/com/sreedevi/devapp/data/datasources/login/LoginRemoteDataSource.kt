package com.sreedevi.devapp.data.datasources.login


import com.qaptive.core.datasources.BaseRemote
import com.qaptive.core.ktx.Observable.applyNetworkSchedulers
import com.qaptive.core.models.APIResult
import com.sreedevi.devapp.api.ApiService
import com.sreedevi.devapp.model.LoginRequest
import com.sreedevi.devapp.model.LoginResponse
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class LoginRemoteDataSource @Inject constructor(private val apiService: ApiService): BaseRemote(),LoginDataSource.Remote {
    override fun login(request: LoginRequest): Single<APIResult<LoginResponse>> {
        return apiService.login(request).createResult().applyNetworkSchedulers()
    }


}