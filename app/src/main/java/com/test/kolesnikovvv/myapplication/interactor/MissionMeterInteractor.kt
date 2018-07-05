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
        GamePoints.mySecVp[0] = sharedPref.getInt("myFb", 0)
        GamePoints.oppSecVp[0] = sharedPref.getInt("oppFb", 0)
        GamePoints.mySecVp[1] = sharedPref.getInt("myWk", 0)
        GamePoints.oppSecVp[1] = sharedPref.getInt("oppWk", 0)
        GamePoints.mySecVp[2] = sharedPref.getInt("myBl", 0)
        GamePoints.oppSecVp[2] = sharedPref.getInt("oppBl", 0)
        GamePoints.myName = sharedPref.getString("myName", "вас")
    }

    override fun updatePreferencesFromClass(context: Context) {
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(context)
        with(sharedPref.edit()) {
            putString("gameData", com.test.kolesnikovvv.myapplication.entity.GamePoints.parseEtResultFromClassToString())
            putInt("myFb", GamePoints.mySecVp[0])
            putInt("oppFb", GamePoints.oppSecVp[0])
            putInt("myWk", GamePoints.mySecVp[1])
            putInt("oppWk", GamePoints.oppSecVp[1])
            putInt("myBl", GamePoints.mySecVp[2])
            putInt("oppBl", GamePoints.oppSecVp[2])
            putString("myName", GamePoints.myName)
            apply()
        }
    }
}