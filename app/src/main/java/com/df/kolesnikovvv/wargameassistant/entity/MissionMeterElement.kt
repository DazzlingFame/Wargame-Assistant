package com.df.kolesnikovvv.wargameassistant.entity

interface MissionMeterElement {

    val type: Type

    enum class Type {
        SEC_MISSION,
        TURN_VP
    }
}