package com.sreedevi.devapp.di.preferences

import com.sreedevi.devapp.data.localdata.DefaultPreference
import com.sreedevi.devapp.data.localdata.PreferenceProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class PreferenceModule {

    @Singleton
    @Binds
    abstract fun defaultPreference(impl: DefaultPreference):PreferenceProvider

}