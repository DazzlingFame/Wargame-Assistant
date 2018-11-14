package com.df.kolesnikovvv.wargameassistant.interactor

import android.content.Context
import android.preference.PreferenceManager
import com.df.kolesnikovvv.wargameassistant.MissionMeterContract
import com.df.kolesnikovvv.wargameassistant.entity.GamePoints
import com.df.kolesnikovvv.wargameassistant.entity.TurnVp

class MissionMeterInteractor: MissionMeterContract.Interactor {

    override fun updateClassFromPreferences(context: Context) {
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(context)
//        val savedEtVp = sharedPref.getString("gameData", ",,,,,,,;,,,,,,,")
        val savedEtVp = sharedPref.getString("gameData", "")

        val mySecMissionVp = sharedPref.getString("mySecVp", "0,0,0")
        val oppSecMissionVp = sharedPref.getString("oppSecVp", "0,0,0")

        parseEtResultStringToClass(savedEtVp)

        val mySecMissionArray: List<String> = mySecMissionVp.split(",")
        val oppSecMissionArray: List<String> = oppSecMissionVp.split(",")

        GamePoints.mySecVp[0] = mySecMissionArray[0].toInt()
        GamePoints.mySecVp[1] = mySecMissionArray[1].toInt()
        GamePoints.mySecVp[2] = mySecMissionArray[2].toInt()

        GamePoints.oppSecVp[0] = oppSecMissionArray[0].toInt()
        GamePoints.oppSecVp[1] = oppSecMissionArray[1].toInt()
        GamePoints.oppSecVp[2] = oppSecMissionArray[2].toInt()

        GamePoints.myName = sharedPref.getString("myName", "")
    }

    override fun updatePreferencesFromClass(context: Context) {
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(context)
        val mySecMissionVp: String = GamePoints.mySecVp[0].toString() + "," + GamePoints.mySecVp[1].toString() + "," + GamePoints.mySecVp[2].toString()
        val oppSecMissionVp: String = GamePoints.oppSecVp[0].toString() + "," + GamePoints.oppSecVp[1].toString() + "," + GamePoints.oppSecVp[2].toString()

        val gameDataString = parseEtResultClassToString()

        with(sharedPref.edit()) {
            putString("gameData", parseEtResultClassToString())
            putString("mySecVp", mySecMissionVp)
            putString("oppSecVp", oppSecMissionVp)

            putString("myName", GamePoints.myName)
            apply()
        }
    }

    fun parseEtResultClassToString(): String {
//        var resultString = ""
////        for (i in 0 until GamePoints.myTurnVp.size - 1) {
////            resultString = resultString + GamePoints.myTurnVp[i] + ","
////        }
////
////        resultString += GamePoints.myTurnVp[GamePoints.myTurnVp.size - 1]
////
////        resultString += ";"
////
////
////
////        for (i in 0 until (GamePoints.oppTurnVp.size - 1)) {
////            resultString = resultString + GamePoints.oppTurnVp[i] + ","
////        }
////        resultString += GamePoints.oppTurnVp[GamePoints.oppTurnVp.size - 1]
////
////
////
////        return resultString

        var resultString = ""
        val gameSize = GamePoints.gameVp.size

        for (i in 0 until gameSize - 1) {
            resultString += GamePoints.gameVp[i].myVp + "," + GamePoints.gameVp[i].oppVp
            resultString += ";"
        }

        resultString += GamePoints.gameVp[gameSize - 1].myVp + "," + GamePoints.gameVp[gameSize - 1].oppVp

        return resultString

    }

    fun parseEtResultStringToClass(result: String) {
//            val myResult = result.substring(0, result.indexOf(";"))
//            GamePoints.myTurnVp = myResult.split(",").toTypedArray()
//
//            val oppResult = result.substring(result.indexOf(";") + 1, result.length)
//            GamePoints.oppTurnVp = oppResult.split(",").toTypedArray()

        if (result == "") {
            GamePoints.gameVp = TurnVp.getEmptyGame(GamePoints.gameSize)
        } else {
//            var gameData = result
//            var turnData: String

            val turnsArray = result.split(";")
            for ((currentIndex, turnData) in turnsArray.withIndex()) {
                val delimeterIndex = turnData.indexOf(",")
                if (turnData.lastIndex == delimeterIndex) {
                    GamePoints.gameVp[currentIndex] = TurnVp(currentIndex, turnData.substring(0, delimeterIndex), "")
                } else {
                    GamePoints.gameVp[currentIndex] = TurnVp(currentIndex, turnData.substring(0, delimeterIndex), turnData.substring(delimeterIndex + 1, turnData.length))
                }
            }


//            while (gameData.contains(";")) {
//                turnData = gameData.substring(0, result.indexOf(";"))
//                val delimeterIndex = turnData.indexOf(",")
//                if (delimeterIndex == 0) {
//                    GamePoints.gameVp[currentIndex] = TurnVp(currentIndex, "", "")
//                } else {
//                    GamePoints.gameVp[currentIndex] = TurnVp(currentIndex, turnData.substring(0, delimeterIndex), turnData.substring(delimeterIndex + 1, turnData.length))
//                }
//
//                currentIndex++
//
//                gameData = gameData.substring(gameData.indexOf(";") + 1, gameData.length)
//            }
        }
    }
}