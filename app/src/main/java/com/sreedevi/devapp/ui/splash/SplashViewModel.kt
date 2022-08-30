package com.sreedevi.devapp.ui.splash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.qaptive.core.viewmodel.BaseViewModel
import com.sreedevi.devapp.DevAppViewModel
import com.sreedevi.devapp.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() : DevAppViewModel() {

    val liveData: MutableLiveData<SplashModel> = MutableLiveData()

    fun initSplashScreen() {
        viewModelScope.launch {
            delay(2000)
            updateLiveData()

        }
    }

    private fun updateLiveData() {
        val splashModel = SplashModel()
        liveData.value=splashModel
    }

    fun navigateTo() {
        navigate(R.id.action_splashFragment_to_loginFragment)
    }

    class SplashModel {

    }
}