package com.df.kolesnikovvv.wargameassistant.view.activities

import android.app.Activity
import android.os.Build
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import com.df.kolesnikovvv.wargameassistant.R

abstract class BaseDrawerActivity: AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout


    override fun onResume() {
        super.onResume()

        this.getToolbarInstance()?.let { this.initView(it) }
    }

    protected fun fixStatusBar() {
        val window = window
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                window.statusBarColor = getColor(R.color.colorPrimaryDark)
            }
        }
    }

    protected fun closeKeyboard() {
        val inputManager: InputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(currentFocus.windowToken, InputMethodManager.SHOW_FORCED)
    }

    private fun initView(toolbar: Toolbar) {
        // Toolbar setup
        drawerLayout = findViewById(R.id.drawer_layout)
        setSupportActionBar(toolbar)   // Replaces the 'ActionBar' with the 'Toolbar'
        val toggle = ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    abstract fun getToolbarInstance(): Toolbar?
}