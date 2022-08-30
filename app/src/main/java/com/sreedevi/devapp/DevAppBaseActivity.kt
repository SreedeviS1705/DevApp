package com.sreedevi.devapp

import com.qaptive.core.models.Action
import com.qaptive.core.ui.BaseActivity

abstract class DevAppBaseActivity : BaseActivity(){
    override fun onPerformAction(action: Action) {
        when (action.task.action) {
            else -> {
                super.onPerformAction(action)
            }
        }
    }
}