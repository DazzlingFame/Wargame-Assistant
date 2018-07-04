package com.test.kolesnikovvv.myapplication.view.activities

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.WindowManager
import com.test.kolesnikovvv.myapplication.R

abstract class BaseActivity: AppCompatActivity() {

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
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    abstract fun getToolbarInstance(): Toolbar?
}