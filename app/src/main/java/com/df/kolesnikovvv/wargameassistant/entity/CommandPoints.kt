package com.df.kolesnikovvv.wargameassistant.entity

class CommandPoints {

    companion object {
        var myCp: Int = 0
        var oppCp: Int = 0

        fun reset() {
            this.myCp = 0
            this.oppCp = 0
        }

    }
}