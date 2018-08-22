package com.df.kolesnikovvv.wargameassistant.interactor

import android.content.Context
import android.preference.PreferenceManager
import com.df.kolesnikovvv.wargameassistant.CpMeterContract
import com.df.kolesnikovvv.wargameassistant.entity.CommandPoints

class CpMeterInteractor : CpMeterContract.Interactor {
    override fun updateClassFromPreferences(context: Context) {
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(context)
        CommandPoints.myCp = sharedPref.getInt("myCp", 0)
        CommandPoints.oppCp = sharedPref.getInt("oppCp", 0)
    }

    override fun updatePreferencesFromClass(context: Context) {
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(context)

        with(sharedPref.edit()) {
            putInt("myCp", CommandPoints.myCp)
            putInt("oppCp", CommandPoints.oppCp)
            apply()
        }
    }
}