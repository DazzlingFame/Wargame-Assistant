package com.df.kolesnikovvv.wargameassistant.view.activities

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.df.kolesnikovvv.wargameassistant.R

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
        if (bigData == "")
            cv_unit_big_data.visibility = View.INVISIBLE
        else
            tv_unit_big_data.text = bigData

        // Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713
        MobileAds.initialize(this, "ca-app-pub-9010106401458654~5798466256")

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
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

     override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
         return true
    }
}

