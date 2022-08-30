package com.sreedevi.devapp.api

import android.util.Log
import com.sreedevi.devapp.data.localdata.PreferenceProvider
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private val preferenceProvider: PreferenceProvider,private val baseUrl :String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        if (chain.request().url.toUri().toString().startsWith(baseUrl)){
            if (preferenceProvider.getAuthToken() != null){
                builder.addHeader("token",preferenceProvider.getAuthToken()!!)
                Log.v("OkHttp auth", preferenceProvider.getAuthToken() ?: "")
            }
        }
        return chain.proceed(builder.build())
    }
}