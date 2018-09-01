package com.df.kolesnikovvv.wargameassistant.view.activities

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView
import com.df.kolesnikovvv.wargameassistant.R
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class BigCardActivity : BaseActivity() {
    private lateinit var mAdView: AdView
    private lateinit var scrollView: ScrollView

    private val toolbar: Toolbar by lazy { findViewById<Toolbar>(R.id.toolbar) }
    override fun getToolbarInstance(): Toolbar? = toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_big_card)
        getToolbarInstance()
        fixStatusBar()

        scrollView = findViewById(R.id.scroll_view)

        val name = intent.getStringExtra("name")
        val stats = intent.getStringExtra("stats")
        val image = intent.getStringExtra("image")
        val weapons = intent.getStringExtra("weapons")
        val bigData = intent.getStringExtra("bigData")

        val ivUnitInfo: ImageView = findViewById(R.id.iv_unit_info)
        val tvUnitInfoHeader: TextView = findViewById(R.id.tv_unit_info_header)
        val tvUnitInfoStats: TextView = findViewById(R.id.tv_unit_info_stats)
        val tvUnitInfoWeapons: TextView = findViewById(R.id.tv_unit_weapons)
        val tvUnitInfoBigData: TextView = findViewById(R.id.tv_unit_big_data)



        ivUnitInfo.setImageResource(image.toInt())
        tvUnitInfoHeader.text = name
        tvUnitInfoStats.text = stats
        tvUnitInfoWeapons.text = weapons
        if (bigData == "")
            tvUnitInfoBigData.visibility = View.INVISIBLE
        else
            tvUnitInfoBigData.text = bigData

        // Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713
        MobileAds.initialize(this, "ca-app-pub-9010106401458654~5798466256")

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        mAdView.adListener = object: AdListener() {
            override fun onAdLoaded() {
                val scale = resources.displayMetrics.density
                val dpAsPixels = (50 * scale + 0.5f).toInt()
                scrollView.setPadding(0,0,0, dpAsPixels)
            }
        }
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

