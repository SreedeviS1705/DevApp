package com.sreedevi.devapp.ui.splash

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.qaptive.core.ui.BaseFragment
import com.sreedevi.devapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment(override val viewModel: SplashViewModel) :
    BaseFragment<SplashViewModel>(R.layout.fragment_splash) {


}