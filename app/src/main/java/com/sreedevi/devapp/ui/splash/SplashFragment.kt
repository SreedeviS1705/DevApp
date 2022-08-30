package com.sreedevi.devapp.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.*
import com.qaptive.core.constants.Actions
import com.qaptive.core.models.Action
import com.qaptive.core.ui.BaseFragment
import com.qaptive.core.ui.ToolbarProvider
import com.sreedevi.devapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : BaseFragment<SplashViewModel>(R.layout.fragment_splash) {

    override val viewModel: SplashViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as ToolbarProvider).toggleDrawerEnabled(false)
        observeSplashLiveData()
    }

    override fun onResume() {
        super.onResume()
        viewModel.performAction(Action(Intent(Actions.ENTER_FULLSCREEN),null))
    }

    override fun onPause() {
        super.onPause()
        viewModel.performAction(Action(Intent(Actions.EXIT_FULLSCREEN),null))
    }

    private fun observeSplashLiveData() {
        viewModel.initSplashScreen()
        val observer = Observer<SplashViewModel.SplashModel>{
            viewModel.navigateTo()
        }
        viewModel.liveData.observe(viewLifecycleOwner,observer)
    }


}