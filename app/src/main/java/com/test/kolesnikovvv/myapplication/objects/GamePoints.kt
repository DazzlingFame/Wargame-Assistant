package com.test.kolesnikovvv.myapplication.objects

class GamePoints {

    companion object {
        var myName = "вас"
        var oppName = "оппонента"
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
            this.myFb = 0
            this.oppFb = 0
            this.myWk = 0
            this.oppWk = 0
            this.myBl = 0
            this.oppBl = 0
            this.myTurnVp = arrayOf("","","","","","","")
            this.oppTurnVp = arrayOf("","","","","","","")
        }

        fun generateResult(): String {
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

            val vpDifference: Int
            var winnerName = this.myName

            if (myTotalVp > oppTotalVp) {
                vpDifference = myTotalVp - oppTotalVp
                winnerName = this.myName
            }
            else {
                vpDifference = oppTotalVp - myTotalVp
                winnerName = this.oppName
            }

            return "У вас $myTotalVp победных очков\nУ противника $oppTotalVp победных очков\nРазница - $vpDifference в пользу $winnerName"
        }

        fun generateShortResult(): String {
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

            val vpDifference = myTotalVp - oppTotalVp

            return "${this.myName} - ${this.oppName} // $myTotalVp - $oppTotalVp // $vpDifference"
        }
    }
}