package com.test.kolesnikovvv.myapplication.entity

interface MissionMeterElement {

    val type: Type

    enum class Type {
        SEC_MISSION,
        TURN_VP
    }
}