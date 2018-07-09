package com.test.kolesnikovvv.myapplication.entity

class GamePoints {

    enum class totalVpTypes {
        MY_TOTAL_VP,
        OPP_TOTAL_VP,
        TOTAL_RESULT
    }

    companion object {
        var myName = ""
        var oppName = ""

        var myTurnVp: Array<String> = arrayOf("","","","","","","")
        var oppTurnVp: Array<String> = arrayOf("","","","","","","")

        var mySecVp: ArrayList<Int> = arrayListOf(0, 0, 0)
        var oppSecVp: ArrayList<Int> = arrayListOf(0, 0, 0)


        fun parseToTurnVpArrayList(): ArrayList<TurnVp> {
            val turnArray: ArrayList<TurnVp> = arrayListOf()
            for (index in 0..6) {
                turnArray.add(TurnVp(index, myTurnVp[index], oppTurnVp[index]))
            }

            return turnArray
        }

        fun parseToSecMissionsArrayList(missionNameArray: ArrayList<String>): ArrayList<SecondaryMissionVp> {
            val secMissionsArray: ArrayList<SecondaryMissionVp> = arrayListOf()
            for (item in missionNameArray) {
                secMissionsArray.add(SecondaryMissionVp(missionNameArray.indexOf(item), item, GamePoints.mySecVp[missionNameArray.indexOf(item)] == 1, GamePoints.oppSecVp[missionNameArray.indexOf(item)] == 1, true))
            }
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
            return "У вас ${result[totalVpTypes.MY_TOTAL_VP]} победных очков\nУ оппонента ${result[totalVpTypes.OPP_TOTAL_VP]} победных очков\nИтоговый счет: ${result[totalVpTypes.TOTAL_RESULT]}/" + (20 - result[totalVpTypes.TOTAL_RESULT]!!)
        }

        fun generateShortResult(): String {
            val result = generateResult()
            return "$myName - $oppName // ${result[totalVpTypes.MY_TOTAL_VP]} - ${result[totalVpTypes.OPP_TOTAL_VP]} // ${result[totalVpTypes.TOTAL_RESULT]} - " + (20 - result[totalVpTypes.TOTAL_RESULT]!!)
        }

        private fun generateResult(): Map<totalVpTypes, Int> {
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

            return mapOf(totalVpTypes.MY_TOTAL_VP to myTotalVp,
                    totalVpTypes.OPP_TOTAL_VP to oppTotalVp,
                    totalVpTypes.TOTAL_RESULT to totalResult)
        }

    }
}