package com.df.kolesnikovvv.wargameassistant.entity

class GamePoints {

    enum class TotalVpTypes {
        MY_TOTAL_VP,
        OPP_TOTAL_VP,
        TOTAL_RESULT
    }

    companion object {
        const val gameSize = 7
        var myName = ""
        var oppName = ""

        var gameVp: ArrayList<TurnVp> = TurnVp.getEmptyGame(gameSize)

        var mySecVp: ArrayList<Int> = arrayListOf(0, 0, 0)
        var oppSecVp: ArrayList<Int> = arrayListOf(0, 0, 0)

        fun parseToSecMissionsArrayList(missionNameArray: ArrayList<String>): ArrayList<SecondaryMissionVp> {
            val secMissionsArray: ArrayList<SecondaryMissionVp> = arrayListOf()
            for (item in missionNameArray) {
                secMissionsArray.add(SecondaryMissionVp(missionNameArray.indexOf(item), item, GamePoints.mySecVp[missionNameArray.indexOf(item)] == 1, GamePoints.oppSecVp[missionNameArray.indexOf(item)] == 1, true))
            }
            return secMissionsArray
        }

        fun reset() {
            gameVp = TurnVp.getEmptyGame(gameSize)
            mySecVp = arrayListOf(0, 0, 0)
            oppSecVp = arrayListOf(0, 0, 0)
        }

        fun generateFullResult(): String {
            val result = generateResult()
            return "У вас ${result[TotalVpTypes.MY_TOTAL_VP]} победных очков\nУ оппонента ${result[TotalVpTypes.OPP_TOTAL_VP]} победных очков\nИтоговый счет: ${result[TotalVpTypes.TOTAL_RESULT]}/" + (20 - result[TotalVpTypes.TOTAL_RESULT]!!)
        }

        fun generateShortResult(): String {
            val result = generateResult()
            return "$myName - $oppName // ${result[TotalVpTypes.MY_TOTAL_VP]} - ${result[TotalVpTypes.OPP_TOTAL_VP]} // ${result[TotalVpTypes.TOTAL_RESULT]} - " + (20 - result[TotalVpTypes.TOTAL_RESULT]!!)
        }

        private fun generateResult(): Map<TotalVpTypes, Int> {
            var myTotalVp = 0
            var oppTotalVp = 0
            for (i in gameVp) {
                if (i.myVp != "") {
                    myTotalVp += i.myVp.toInt()
                }
                if (i.oppVp != "") {
                    oppTotalVp += i.oppVp.toInt()
                }

            }
            myTotalVp += mySecVp[0] + mySecVp[1] + mySecVp[2]
            oppTotalVp += oppSecVp[0] + oppSecVp[1] + oppSecVp[2]

            val vpDifference = when {
                myTotalVp - oppTotalVp > 20 -> 20
                myTotalVp - oppTotalVp < -20 -> -20
                else -> myTotalVp - oppTotalVp
            }
            val totalResult = 10 + vpDifference / 2

            return mapOf(TotalVpTypes.MY_TOTAL_VP to myTotalVp,
                    TotalVpTypes.OPP_TOTAL_VP to oppTotalVp,
                    TotalVpTypes.TOTAL_RESULT to totalResult)
        }

    }
}