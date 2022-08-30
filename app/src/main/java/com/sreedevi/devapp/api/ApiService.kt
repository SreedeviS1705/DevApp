package com.sreedevi.devapp.api

import com.qaptive.core.models.DefaultResponse
import com.sreedevi.devapp.constants.ApiUrls
import com.sreedevi.devapp.model.LoginRequest
import com.sreedevi.devapp.model.LoginResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.adapter.rxjava3.Result
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST(ApiUrls.LOGIN)
    fun login(@Body request: LoginRequest): Single<Result<DefaultResponse<LoginResponse>>>
}