package com.test.kolesnikovvv.myapplication.entity

class GamePoints {
    companion object {
        var myName = ""
        var oppName = ""

        var myTurnVp: Array<String> = arrayOf("","","","","","","")
        var oppTurnVp: Array<String> = arrayOf("","","","","","","")

        var mySecVp: ArrayList<Int> = arrayListOf(0, 0, 0)
        var oppSecVp: ArrayList<Int> = arrayListOf(0, 0, 0)

        fun parseFromStringToClass(data: String) {
            val myResult = data.substring(0, data.indexOf(";"))
            myTurnVp = myResult.split(",").toTypedArray()

            val oppResult = data.substring(data.indexOf(";") + 1, data.length)
            oppTurnVp = oppResult.split(",").toTypedArray()
        }

        fun parseEtResultFromClassToString(): String {
            var resultString = ""
            for (i in 0 until myTurnVp.size - 1) {
                resultString = resultString + myTurnVp[i] + ","
            }
            resultString += myTurnVp[myTurnVp.size - 1]

            resultString = "$resultString;"

            for (i in 0 until (oppTurnVp.size - 1)) {
                resultString = resultString + oppTurnVp[i] + ","
            }
            resultString += oppTurnVp[oppTurnVp.size - 1]

            return resultString
        }

        fun parseToTurnVpArrayList(): ArrayList<TurnVp> {
            val turnArray: ArrayList<TurnVp> = arrayListOf()
            for (index in 0..6) {
                turnArray.add(TurnVp(index, myTurnVp[index], oppTurnVp[index]))
            }

            return turnArray
        }

        fun parseToSecMissionsArrayList(): ArrayList<SecondaryMissionVp> {
            val secMissionsArray: ArrayList<SecondaryMissionVp> = arrayListOf()
            secMissionsArray.add(SecondaryMissionVp(0, "First blood", GamePoints.mySecVp[0] == 1, GamePoints.oppSecVp[0] == 1, true))
            secMissionsArray.add(SecondaryMissionVp(1, "Slay the Warlord", GamePoints.mySecVp[1] == 1, GamePoints.oppSecVp[1] == 1, true))
            secMissionsArray.add(SecondaryMissionVp(2, "Behind enemy lines", GamePoints.mySecVp[2] == 1, GamePoints.oppSecVp[2] == 1, true))

            return secMissionsArray
        }

        fun reset() {
            myTurnVp = arrayOf("","","","","","","")
            oppTurnVp = arrayOf("","","","","","","")
            mySecVp = arrayListOf(0, 0, 0)
            oppSecVp = arrayListOf(0, 0, 0)
        }

        fun generateFullResult(): String {
            val result = generateResult()
            return "У вас ${result["myTotalVp"]} победных очков\nУ оппонента ${result["oppTotalVp"]} победных очков\nИтоговый счет: ${result["totalResult"]}/" + (20 - result["totalResult"]!!)
        }

        fun generateShortResult(): String {
            val result = generateResult()
            return "$myName - $oppName // ${result["myTotalVp"]} - ${result["oppTotalVp"]} // ${result["totalResult"]} - " + (20 - result["totalResult"]!!)
        }

        private fun generateResult(): Map<String, Int> {
            var myTotalVp = 0
            for (i in myTurnVp) {
                if (i != "")
                    myTotalVp += i.toInt()
            }
            myTotalVp += mySecVp[0] + mySecVp[1] + mySecVp[2]

            var oppTotalVp = 0
            for (i in oppTurnVp) {
                if (i != "")
                    oppTotalVp += i.toInt()
            }
            oppTotalVp += oppSecVp[0] + oppSecVp[1] + oppSecVp[2]

            val vpDifference = when {
                myTotalVp - oppTotalVp > 20 -> 20
                myTotalVp - oppTotalVp < -20 -> -20
                else -> myTotalVp - oppTotalVp
            }
            val totalResult = 10 + vpDifference / 2

            return mapOf("myTotalVp" to myTotalVp,
                    "oppTotalVp" to oppTotalVp,
                    "totalResult" to totalResult)
        }

    }
}