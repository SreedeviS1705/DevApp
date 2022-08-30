package com.sreedevi.devapp.ui.login

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.qaptive.core.constants.Actions
import com.qaptive.core.ktx.FragmentKtx.viewBinding
import com.qaptive.core.models.Action
import com.qaptive.core.ui.BaseFragment
import com.sreedevi.devapp.R
import com.sreedevi.devapp.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<LoginViewModel>(R.layout.fragment_login) {
    override val viewModel: LoginViewModel by viewModels()

    private val binder by viewBinding(FragmentLoginBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binder.viewmodel=viewModel
    }

    override fun onResume() {
        super.onResume()
        viewModel.performAction(Action(Intent(Actions.ENTER_FULLSCREEN)))
    }

    override fun onPause() {
        super.onPause()
        viewModel.performAction(Action(Intent(Actions.EXIT_FULLSCREEN)))
    }
}