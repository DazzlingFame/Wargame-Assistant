package com.test.kolesnikovvv.myapplication.interactor

import android.content.Context
import android.preference.PreferenceManager
import com.test.kolesnikovvv.myapplication.MissionMeterContract
import com.test.kolesnikovvv.myapplication.entity.GamePoints

class MissionMeterInteractor: MissionMeterContract.Interactor {

    override fun updateClassFromPreferences(context: Context) {
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(context)
        val savedEtVp = sharedPref.getString("gameData", ",,,,,,,;,,,,,,,")
        val mySecMissionVp = sharedPref.getString("mySecVp", "0,0,0")
        val oppSecMissionVp = sharedPref.getString("oppSecVp", "0,0,0")

        parseEtResultToClass(savedEtVp)
        val mySecMissionArray: List<String> = mySecMissionVp.split(",")
        val oppSecMissionArray: List<String> = oppSecMissionVp.split(",")

        GamePoints.mySecVp[0] = mySecMissionArray[0].toInt()
        GamePoints.mySecVp[1] = mySecMissionArray[1].toInt()
        GamePoints.mySecVp[2] = mySecMissionArray[2].toInt()

        GamePoints.oppSecVp[0] = oppSecMissionArray[0].toInt()
        GamePoints.oppSecVp[1] = oppSecMissionArray[1].toInt()
        GamePoints.oppSecVp[2] = oppSecMissionArray[2].toInt()

        GamePoints.myName = sharedPref.getString("myName", "вас")
    }

    override fun updatePreferencesFromClass(context: Context) {
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(context)
        val mySecMissionVp: String = GamePoints.mySecVp[0].toString() + "," + GamePoints.mySecVp[1].toString() + "," + GamePoints.mySecVp[2].toString()
        val oppSecMissionVp: String = GamePoints.oppSecVp[0].toString() + "," + GamePoints.oppSecVp[1].toString() + "," + GamePoints.oppSecVp[2].toString()

        with(sharedPref.edit()) {
            putString("gameData", parseEtResultToString())
            putString("mySecVp", mySecMissionVp)
            putString("oppSecVp", oppSecMissionVp)

            putString("myName", GamePoints.myName)
            apply()
        }
    }

    fun parseEtResultToString(): String {
        var resultString = ""
        for (i in 0 until GamePoints.myTurnVp.size - 1) {
            resultString = resultString + GamePoints.myTurnVp[i] + ","
        }
        resultString += GamePoints.myTurnVp[GamePoints.myTurnVp.size - 1]

        resultString += ";"

        for (i in 0 until (GamePoints.oppTurnVp.size - 1)) {
            resultString = resultString + GamePoints.oppTurnVp[i] + ","
        }
        resultString += GamePoints.oppTurnVp[GamePoints.oppTurnVp.size - 1]

        return resultString
    }

    fun parseEtResultToClass(result: String) {
            val myResult = result.substring(0, result.indexOf(";"))
            GamePoints.myTurnVp = myResult.split(",").toTypedArray()

            val oppResult = result.substring(result.indexOf(";") + 1, result.length)
            GamePoints.oppTurnVp = oppResult.split(",").toTypedArray()
    }
}