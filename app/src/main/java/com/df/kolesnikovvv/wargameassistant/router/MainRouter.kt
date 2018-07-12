package com.df.kolesnikovvv.wargameassistant.router

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import com.df.kolesnikovvv.wargameassistant.MainContract
import com.df.kolesnikovvv.wargameassistant.entity.Unit
import com.df.kolesnikovvv.wargameassistant.view.activities.BigCardActivity
import com.df.kolesnikovvv.wargameassistant.view.activities.MissionMeterActivity

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