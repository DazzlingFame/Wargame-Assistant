package com.df.kolesnikovvv.wargameassistant.view.activities

import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.WindowManager
import com.df.kolesnikovvv.wargameassistant.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

abstract class BaseDrawerActivity: AppCompatActivity() {

    override fun onResume() {
        super.onResume()

        this.getToolbarInstance()?.let { this.initView(it) }
    }

    protected fun fixStatusBar() {
        val window = window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.statusBarColor = getColor(R.color.colorPrimaryDark)
    }

    private fun initView(toolbar: Toolbar) {
        // Toolbar setup
        setSupportActionBar(toolbar)   // Replaces the 'ActionBar' with the 'Toolbar'
        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
    }

    abstract fun getToolbarInstance(): Toolbar?
}