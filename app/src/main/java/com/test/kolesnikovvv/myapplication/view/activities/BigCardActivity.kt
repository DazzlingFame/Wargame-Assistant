package com.test.kolesnikovvv.myapplication.view.activities

import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.test.kolesnikovvv.myapplication.R

import kotlinx.android.synthetic.main.activity_big_card.*
import kotlinx.android.synthetic.main.content_big_card.*

class BigCardActivity : BaseActivity() {
    private lateinit var mAdView: AdView

    override fun getToolbarInstance(): Toolbar? = toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_big_card)
        getToolbarInstance()
        fixStatusBar()

        val name = intent.getStringExtra("name")
        val stats = intent.getStringExtra("stats")
        val image = intent.getStringExtra("image")
        val weapons = intent.getStringExtra("weapons")
        val bigData = intent.getStringExtra("bigData")

        iv_unit_info.setImageResource(image.toInt())
        tv_unit_info_header.text = name
        tv_unit_info_stats.text = stats
        tv_unit_weapons.text = weapons
        tv_unit_big_data.text = bigData

        // Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713")

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

    }

     override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
         return true
    }
}

