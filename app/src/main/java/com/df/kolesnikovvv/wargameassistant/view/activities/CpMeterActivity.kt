package com.df.kolesnikovvv.wargameassistant.view.activities

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import com.df.kolesnikovvv.wargameassistant.DrawerContract
import com.df.kolesnikovvv.wargameassistant.R
import com.df.kolesnikovvv.wargameassistant.presenter.DrawerPresenter
import kotlinx.android.synthetic.main.activity_cp_meter.*

class CpMeterActivity : BaseDrawerActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val toolbar: Toolbar by lazy { findViewById<Toolbar>(R.id.toolbar) }
    override fun getToolbarInstance(): Toolbar? = toolbar

    private var drawerPresenter: DrawerContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cp_meter)
        getToolbarInstance()

        drawerPresenter = DrawerPresenter(this)

        findViewById<NavigationView>(R.id.nav_view).setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        drawerPresenter?.navigationItemSelected(item, this)
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

}
