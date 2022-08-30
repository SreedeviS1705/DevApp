package com.sreedevi.devapp.data.localdata

interface PreferenceProvider {
    fun clearData()
    fun getAuthToken():String?
    fun setAuthToken(token:String?)
    fun setUserId(userId: String?)
    fun getUserId():String?
}