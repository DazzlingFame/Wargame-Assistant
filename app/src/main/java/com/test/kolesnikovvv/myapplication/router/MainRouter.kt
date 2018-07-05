package com.test.kolesnikovvv.myapplication.router

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import com.test.kolesnikovvv.myapplication.MainContract
import com.test.kolesnikovvv.myapplication.entity.Unit
import com.test.kolesnikovvv.myapplication.view.activities.BigCardActivity
import com.test.kolesnikovvv.myapplication.view.activities.MissionMeterActivity

class MainRouter: MainContract.Router {

    override fun navigateToBigCard(item: Unit, context: Context) {
        val intent = Intent(context, BigCardActivity::class.java)
        intent.putExtra("name", item.name)
        intent.putExtra("stats", item.stats)
        intent.putExtra("image", item.image.toString())
        intent.putExtra("weapons", item.weapons)
        intent.putExtra("bigData", item.bigData)
        startActivity(context, intent, null)
    }

    override fun navigateToMissionMeter(context: Context) {
        val intent = Intent(context, MissionMeterActivity::class.java)
        startActivity(context, intent, null)
    }
}