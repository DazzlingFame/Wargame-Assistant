package com.test.kolesnikovvv.myapplication.entity

import android.os.Parcel
import android.os.Parcelable

class GamePoints(var myName: String = "",
                 var oppName: String = "",
                 var myTurnVp:Array<String> = arrayOf("","","","","","",""),
                 var oppTurnVp: Array<String> = arrayOf("","","","","","",""),
                 var mySecVp: Array<Int> = arrayOf(0, 0, 0),
                 var oppSecVp: ArrayList<Int> = arrayListOf(0, 0, 0)) : Parcelable {

    private constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.createStringArray(),
            parcel.createStringArray(),
            parcel.createIntArray()
//            parcel.readStringList(),
//            parcel.readStringArray(),
//            parcel.readArrayList(),
//            parcel.readArrayList()
            )



    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(myName)
        parcel.writeString(oppName)
        parcel.writeArray(myTurnVp)
        parcel.writeArray(oppTurnVp)
        parcel.writeList(mySecVp)
        parcel.writeList(oppSecVp)
    }

    override fun describeContents(): Int {
        return 0
    }

    @JvmField
    val CREATOR = object : Parcelable.Creator<GamePoints> {

        override fun createFromParcel(parcel: Parcel): GamePoints {
            return GamePoints(parcel)
        }

        override fun newArray(size: Int): Array<GamePoints?> {
            return arrayOfNulls(size)
        }
    }

    enum class TotalVpTypes {
        MY_TOTAL_VP,
        OPP_TOTAL_VP,
        TOTAL_RESULT
    }


//        var myName = ""
//        var oppName = ""
//
//        var myTurnVp: Array<String> = arrayOf("","","","","","","")
//        var oppTurnVp: Array<String> = arrayOf("","","","","","","")
//
//        var mySecVp: ArrayList<Int> = arrayListOf(0, 0, 0)
//        var oppSecVp: ArrayList<Int> = arrayListOf(0, 0, 0)


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
                secMissionsArray.add(SecondaryMissionVp(missionNameArray.indexOf(item), item, mySecVp[missionNameArray.indexOf(item)] == 1, oppSecVp[missionNameArray.indexOf(item)] == 1, true))
            }
            return secMissionsArray
        }

        fun reset() {
            myTurnVp = arrayOf("","","","","","","")
            oppTurnVp = arrayOf("","","","","","","")
            mySecVp = arrayOf(0, 0, 0)
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

            return mapOf(TotalVpTypes.MY_TOTAL_VP to myTotalVp,
                    TotalVpTypes.OPP_TOTAL_VP to oppTotalVp,
                    TotalVpTypes.TOTAL_RESULT to totalResult)
        }

    }


}