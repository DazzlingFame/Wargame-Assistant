package com.df.kolesnikovvv.wargameassistant.view.activities

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AlertDialog
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.TextView
import com.df.kolesnikovvv.wargameassistant.CpMeterContract
import com.df.kolesnikovvv.wargameassistant.DrawerContract
import com.df.kolesnikovvv.wargameassistant.R
import com.df.kolesnikovvv.wargameassistant.presenter.CpMeterPresenter
import com.df.kolesnikovvv.wargameassistant.presenter.DrawerPresenter
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class CpMeterActivity : CpMeterContract.View, BaseDrawerActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var mAdView: AdView

    private val presenter: CpMeterContract.Presenter = CpMeterPresenter(this, this)

    private val toolbar: Toolbar by lazy { findViewById<Toolbar>(R.id.toolbar) }
    override fun getToolbarInstance(): Toolbar? = toolbar
    private lateinit var tvMyCp: TextView
    private lateinit var tvOppCp: TextView
    private lateinit var drawerLayout: DrawerLayout

    private var drawerPresenter: DrawerContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cp_meter)
        getToolbarInstance()

        drawerPresenter = DrawerPresenter(this)

        findViewById<NavigationView>(R.id.nav_view).setNavigationItemSelectedListener(this)

        tvMyCp = findViewById(R.id.tv_my_cp)
        tvOppCp = findViewById(R.id.tv_opp_cp)
        drawerLayout = findViewById(R.id.drawer_layout)

        val myCpPlus: ImageButton = findViewById(R.id.btn_my_cp_plus)
        val myCpMinus: ImageButton = findViewById(R.id.btn_my_cp_minus)
        val oppCpPlus: ImageButton = findViewById(R.id.btn_my_opp_plus)
        val oppCpMinus: ImageButton = findViewById(R.id.btn_opp_cp_minus)
        val ibResetCp: ImageButton = findViewById(R.id.ib_reset_cp)

        ibResetCp.setOnClickListener {
            showResetDialog()
        }

        myCpPlus.setOnClickListener {
            presenter.changeCpClicked(true, true)
        }

        myCpMinus.setOnClickListener {
            presenter.changeCpClicked(true, false)
        }
        oppCpPlus.setOnClickListener {
            presenter.changeCpClicked(false, true)
        }
        oppCpMinus.setOnClickListener {
            presenter.changeCpClicked(false, false)
        }

        presenter.onViewCreated()

        // Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713
        MobileAds.initialize(this, "ca-app-pub-9010106401458654/2987228754")
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
    }

    override fun setDataToView(myCp: Int, oppCp: Int) {
        tvMyCp.text = myCp.toString()
        tvOppCp.text = oppCp.toString()
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        drawerPresenter?.navigationItemSelected(item, this)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onStop() {
        presenter.onDestroy()
        super.onStop()
    }

    override fun showResetDialog() {
        val builder = AlertDialog.Builder(this@CpMeterActivity)
        builder.setTitle("Сбросить значения?")

        builder.setPositiveButton("Да") { _, _ ->
            presenter.resetClicked()
        }

        builder.setNegativeButton("Нет") { dialog, which ->
            dialog.dismiss()
        }

        builder.create().show()
    }

    public override fun onResume() {
        super.onResume()

        // Resume the AdView.
        mAdView.resume()
    }

    public override fun onPause() {
        // Pause the AdView.
        mAdView.pause()

        super.onPause()
    }

    public override fun onDestroy() {
        // Destroy the AdView.
        mAdView.destroy()

        super.onDestroy()
    }
}
