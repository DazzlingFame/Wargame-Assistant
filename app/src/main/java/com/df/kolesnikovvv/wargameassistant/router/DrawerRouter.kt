package com.df.kolesnikovvv.wargameassistant.router

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat
import com.df.kolesnikovvv.wargameassistant.DrawerContract
import com.df.kolesnikovvv.wargameassistant.view.activities.CpMeterActivity
import com.df.kolesnikovvv.wargameassistant.view.activities.MainActivity
import com.df.kolesnikovvv.wargameassistant.view.activities.MissionMeterActivity

class DrawerRouter(context: Context) : DrawerContract.Router {
    override fun navigateToCpMeter(context: Context) {
        val intent = Intent(context, CpMeterActivity::class.java)
        ContextCompat.startActivity(context, intent, null)
    }

    override fun navigateToMain(context: Context) {
        val intent = Intent(context, MainActivity::class.java)
        ContextCompat.startActivity(context, intent, null)
    }

    override fun navigateToMissionMeter(context: Context) {
        val intent = Intent(context, MissionMeterActivity::class.java)
        ContextCompat.startActivity(context, intent, null)
    }
}