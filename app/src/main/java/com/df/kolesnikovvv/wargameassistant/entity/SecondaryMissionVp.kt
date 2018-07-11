package com.df.kolesnikovvv.wargameassistant.entity

class SecondaryMissionVp(var missionIndex: Int,
                         var missionName: String,
                         var myStatus: Boolean,
                         var oppStatus: Boolean,
                         var my: Boolean = true,
                         override val type: MissionMeterElement.Type = MissionMeterElement.Type.SEC_MISSION): MissionMeterElement