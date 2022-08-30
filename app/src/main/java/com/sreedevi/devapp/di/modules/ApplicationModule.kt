package com.sreedevi.devapp.di.modules

import com.sreedevi.devapp.BuildConfig
import com.sreedevi.devapp.api.ApiService
import com.sreedevi.devapp.api.AuthInterceptor
import com.sreedevi.devapp.api.ErrorInterceptor
import com.sreedevi.devapp.api.MockInterceptor
import com.sreedevi.devapp.data.localdata.PreferenceProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Authenticator
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import javax.net.ssl.HostnameVerifier

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Singleton
    @Provides
    fun retrofit(preferenceProvider: PreferenceProvider): Retrofit{
        val interceptor = HttpLoggingInterceptor()
        interceptor.level =
            if (BuildConfig.DEBUG)
                HttpLoggingInterceptor.Level.BODY
            else
                HttpLoggingInterceptor.Level.NONE

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor(AuthInterceptor(preferenceProvider,BuildConfig.BASE_URL))
            .addInterceptor(ErrorInterceptor(BuildConfig.BASE_URL))
            .addInterceptor(MockInterceptor(BuildConfig.BASE_URL))
            .hostnameVerifier(HostnameVerifier{_,_ -> true})
            .build()

        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(client)
            .build()

    }

    @Singleton
    @Provides
    fun getApiService(retrofit: Retrofit):ApiService{
        return retrofit.create(ApiService::class.java)

    }
}