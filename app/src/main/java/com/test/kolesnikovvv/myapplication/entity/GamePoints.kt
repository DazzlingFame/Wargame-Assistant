package com.test.kolesnikovvv.myapplication.entity

class GamePoints {

    companion object {
        var myName = ""
        var oppName = ""
        var myFb = 0
        var oppFb = 0
        var myWk = 0
        var oppWk = 0
        var myBl = 0
        var oppBl = 0
        var myTurnVp: Array<String> = arrayOf("","","","","","","")
        var oppTurnVp: Array<String> = arrayOf("","","","","","","")

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

        fun reset() {
            myFb = 0
            oppFb = 0
            myWk = 0
            oppWk = 0
            myBl = 0
            oppBl = 0
            myTurnVp = arrayOf("","","","","","","")
            oppTurnVp = arrayOf("","","","","","","")
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
            myTotalVp += myFb + myWk + myBl

            var oppTotalVp = 0
            for (i in oppTurnVp) {
                if (i != "")
                    oppTotalVp += i.toInt()
            }
            oppTotalVp += oppFb + oppWk + oppBl

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