package com.sreedevi.devapp.data.localdata

import android.content.Context
import com.qaptive.core.ktx.PreferenceHelper
import com.qaptive.core.ktx.PreferenceHelper.get
import com.qaptive.core.ktx.PreferenceHelper.set
import com.sreedevi.devapp.App
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class DefaultPreference @Inject constructor(@ApplicationContext context: Context) :PreferenceProvider {

    object Fields{
        const val AUTH_TOKEN = "token"
        const val USERID = "user_id"
    }
    private val sharedPreferences by lazy {
        PreferenceHelper.customPrefs(context,"")
    }

    companion object{
        val instance : DefaultPreference by lazy {  DefaultPreference(App.instance.applicationContext) }

    }

    override fun clearData() {
        sharedPreferences.edit().clear().commit()
    }

    override fun getAuthToken(): String? {
        return sharedPreferences[Fields.AUTH_TOKEN]
    }

    override fun setAuthToken(token: String?) {
        sharedPreferences[Fields.AUTH_TOKEN] = token
    }

    override fun setUserId(userId: String?) {
        sharedPreferences[Fields.USERID] = userId
    }

    override fun getUserId(): String? {
        return sharedPreferences[Fields.USERID]
    }
}