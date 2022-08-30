package com.sreedevi.devapp

import android.app.Application
import com.qaptive.core.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(app: Application): DevAppViewModel(){

}