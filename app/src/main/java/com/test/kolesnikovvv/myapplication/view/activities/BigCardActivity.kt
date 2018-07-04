package com.test.kolesnikovvv.myapplication.view.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.WindowManager
import com.test.kolesnikovvv.myapplication.R

import kotlinx.android.synthetic.main.activity_big_card.*
import kotlinx.android.synthetic.main.content_big_card.*

class BigCardActivity : BaseActivity() {
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
    }

     override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
         return true
    }
}

