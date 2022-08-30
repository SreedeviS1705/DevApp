package com.sreedevi.devapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.qaptive.core.constants.Actions
import com.qaptive.core.ktx.AppCompatActivityKtx.viewBinding
import com.qaptive.core.models.Action
import com.qaptive.core.models.LoadingMessageData
import com.qaptive.core.models.MessageData
import com.qaptive.core.ui.BaseActivity
import com.qaptive.core.ui.ToolbarProvider
import com.qaptive.core.utils.EventObserver
import com.sreedevi.devapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : DevAppBaseActivity() , ToolbarProvider{

    private val binding by viewBinding(ActivityMainBinding::inflate)
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory(App.instance)
    }
    private lateinit var navHostFragment :NavHostFragment
    override lateinit var navigationController: NavController

    override val appBarConfiguration: AppBarConfiguration by lazy {
        AppBarConfiguration(setOf(R.id.loginFragment))

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme_NoActionBar)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.appbar.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        val navController = findNavController(R.id.host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.loginFragment
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        //setupNavigationController()
        //setupViewModel()
    }

    private fun setupViewModel() {
        mainViewModel.action.observe(this, EventObserver {
            onPerformAction(it)
        })
    }

    private fun setupNavigationController() {
        navHostFragment = supportFragmentManager.findFragmentById(R.id.navigation_main) as NavHostFragment
        navigationController = navHostFragment.navController

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.host_fragment)
        return navController.navigateUp()

    }


    override fun onPerformAction(action: Action) {
        super.onPerformAction(action)

    }

    override fun onLoadingMessage(messageData: LoadingMessageData) {
    }

    override fun onInfoMessage(messageData: MessageData) {
    }

    override fun onLogout() {
    }

    override fun setUpToolbar(
        toolbar: Toolbar?,
        collapsingToolbarLayout: CollapsingToolbarLayout?
    ) {
        if (toolbar == null)
            return

        setSupportActionBar(toolbar)
        toolbar.setupWithNavController(navigationController, appBarConfiguration)
        if (collapsingToolbarLayout != null)
            NavigationUI.setupWithNavController(
                collapsingToolbarLayout, toolbar, navigationController, appBarConfiguration
            )
        else
            NavigationUI.setupWithNavController(toolbar, navigationController, appBarConfiguration)
    }

    override fun toggleDrawerEnabled(enableDrawer: Boolean) {
    }

    override fun setTitleText(title: String?) {
        setTitle(title)
    }
}