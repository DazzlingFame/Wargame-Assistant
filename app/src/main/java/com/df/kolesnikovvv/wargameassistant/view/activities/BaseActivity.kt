package com.df.kolesnikovvv.wargameassistant.view.activities

import android.app.Activity
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import com.df.kolesnikovvv.wargameassistant.R

abstract class BaseActivity: AppCompatActivity() {

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
        setSupportActionBar(toolbar)   // Replaces the 'ActionBar' with the 'Toolbar'
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    abstract fun getToolbarInstance(): Toolbar?
}