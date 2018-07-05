package com.test.kolesnikovvv.myapplication.interactor

import android.content.Context
import android.preference.PreferenceManager
import com.test.kolesnikovvv.myapplication.MissionMeterContract
import com.test.kolesnikovvv.myapplication.entity.GamePoints

class MissionMeterInteractor: MissionMeterContract.Interactor {

    override fun updateClassFromPreferences(context: Context) {
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(context)
        val savedEtVp = sharedPref.getString("gameData", ",,,,,,,;,,,,,,,")

        GamePoints.parseFromStringToClass(savedEtVp)
        GamePoints.myFb = sharedPref.getInt("myFb", 0)
        GamePoints.oppFb = sharedPref.getInt("oppFb", 0)
        GamePoints.myWk = sharedPref.getInt("myWk", 0)
        GamePoints.oppWk = sharedPref.getInt("oppWk", 0)
        GamePoints.myBl = sharedPref.getInt("myBl", 0)
        GamePoints.oppBl = sharedPref.getInt("oppBl", 0)
        GamePoints.myName = sharedPref.getString("myName", "вас")
    }

    override fun updatePreferencesFromClass(context: Context) {
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(context)
        with(sharedPref.edit()) {
            putString("gameData", com.test.kolesnikovvv.myapplication.entity.GamePoints.parseEtResultFromClassToString())
            putInt("myFb", GamePoints.myFb)
            putInt("oppFb", GamePoints.oppFb)
            putInt("myWk", GamePoints.myWk)
            putInt("oppWk", GamePoints.oppWk)
            putInt("myBl", GamePoints.myBl)
            putInt("oppBl", GamePoints.oppBl)
            putString("myName", GamePoints.myName)
            apply()
        }
    }
}