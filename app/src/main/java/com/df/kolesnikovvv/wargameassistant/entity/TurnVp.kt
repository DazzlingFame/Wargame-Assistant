package com.df.kolesnikovvv.wargameassistant.entity

class TurnVp(var turnIndex: Int,
             var myVp: String,
             var oppVp: String,
             override val type: MissionMeterElement.Type = MissionMeterElement.Type.TURN_VP): MissionMeterElement {

}