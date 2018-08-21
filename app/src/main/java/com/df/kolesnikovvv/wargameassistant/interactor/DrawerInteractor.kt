package com.df.kolesnikovvv.wargameassistant.interactor

import android.content.Context
import android.preference.PreferenceManager
import com.df.kolesnikovvv.wargameassistant.DrawerContract
import com.df.kolesnikovvv.wargameassistant.R

class DrawerInteractor(context: Context) : DrawerContract.Interactor {


    override fun saveLastFaction(context: Context, factionName: String) {
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(context)
        with(sharedPref.edit()) {
            putString(context.getString(R.string.last_faction_key), factionName)
            apply()
        }
    }
}