package com.sreedevi.devapp.di.login

import com.sreedevi.devapp.data.datasources.login.LoginDataSource
import com.sreedevi.devapp.data.datasources.login.LoginRemoteDataSource
import com.sreedevi.devapp.data.repositories.LoginRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class LoginAbstractARM {

    @Binds
    @ViewModelScoped
    abstract fun loginDataSource(impl: LoginDataSource):LoginRepository

    @Binds
    @ViewModelScoped
    abstract fun loginRemoteDataSource(impl: LoginRemoteDataSource):LoginDataSource.Remote

}