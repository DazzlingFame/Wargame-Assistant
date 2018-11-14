package com.df.kolesnikovvv.wargameassistant.entity

class TurnVp(var turnIndex: Int,
             var myVp: String = "",
             var oppVp: String = "",
             override val type: MissionMeterElement.Type = MissionMeterElement.Type.TURN_VP): MissionMeterElement {
    companion object {

        fun getEmptyGame(number: Int): ArrayList<TurnVp> {
            val turnVps = arrayListOf<TurnVp>()
            for (i in 0 until number) {
                turnVps.add(TurnVp(i))
            }
            return turnVps
        }
    }
}