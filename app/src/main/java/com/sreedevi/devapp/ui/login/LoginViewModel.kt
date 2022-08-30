package com.sreedevi.devapp.ui.login

import android.text.TextUtils
import android.util.Patterns
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sreedevi.devapp.App
import com.sreedevi.devapp.DevAppViewModel
import com.sreedevi.devapp.R
import com.sreedevi.devapp.data.localdata.PreferenceProvider
import com.sreedevi.devapp.data.repositories.LoginRepository
import com.sreedevi.devapp.model.LoginRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: LoginRepository,
    private val preferenceProvider: PreferenceProvider):DevAppViewModel(){

    val email =  MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val emailError = MutableLiveData<String>()
    val passwordError = MutableLiveData<String>()


    fun login(){
        if(validateLogin(email.value,password.value)) {
            loginApi()
        }
    }

    private fun loginApi() {
        showLoading()
        repository.login(
            LoginRequest(email = email.value,password = password.value)
        ).subscribe({result ->
            hideLoading()
            if (result.isSuccess){
                preferenceProvider.setUserId(result.data?.user_id)
                preferenceProvider.setAuthToken(result.data?.auth_token)
                navigate(R.id.action_loginFragment_to_dashboardFragment)
            }else{
                result.error?.showErrorDialogue(
                    positiveButtonRes = R.string.ok,
                    negativeButtonRes = R.string.cancel
                ){}
            }
        },{
            hideLoading()
            showNetworkError(
                negativeButton = R.string.cancel
            ){
                loginApi()
            }

        })
    }

    private fun validateLogin(email: String?, password: String?):Boolean {
        var res = true
        if (email.isNullOrBlank()) {
            res = false
            emailError.value =
                App.instance.getString(R.string.enter_valid_email)
        }
        if (validateEmail(email) == false) {
            res = false
            emailError.value =
                App.instance.getString(R.string.enter_valid_email)
        }
        if (password.isNullOrBlank()) {
            res = false
            passwordError.value =
                App.instance.getString(R.string.enter_valid_password)
        }

        if ((password?.length ?: 0) < 4) {
            res = false
            passwordError.value =
                App.instance.getString(R.string.password_must_greater_than_four)
        }

        return res
    }

    private fun validateEmail(emailId: String?): Boolean? {
        return !TextUtils.isEmpty(emailId) && Patterns.EMAIL_ADDRESS.matcher(emailId).matches()
    }
}