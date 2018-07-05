package com.test.kolesnikovvv.myapplication.view.viewHolders

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import com.test.kolesnikovvv.myapplication.R
import com.test.kolesnikovvv.myapplication.entity.SecondaryMissionVp

class SecondaryMissionsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val missionName: TextView = itemView.findViewById(R.id.sec_mission_name)
    val myStatus: CheckBox = itemView.findViewById(R.id.cb_my_status)
    val oppStatus: CheckBox = itemView.findViewById(R.id.cb_opp_status)

    fun bind(missionStatus: SecondaryMissionVp, clickListener: (SecondaryMissionVp) -> kotlin.Unit) {
        missionName.text = missionStatus.missionName
        myStatus.isChecked = missionStatus.myStatus
        oppStatus.isChecked = missionStatus.oppStatus

        val myMissionStatus = SecondaryMissionVp(missionStatus.missionIndex, missionStatus.missionName, missionStatus.myStatus, missionStatus.oppStatus, true)

        val oppMissionStatus = SecondaryMissionVp(missionStatus.missionIndex, missionStatus.missionName, missionStatus.myStatus, missionStatus.oppStatus, false)

        myStatus.setOnClickListener {clickListener(myMissionStatus)}
        oppStatus.setOnClickListener {clickListener(oppMissionStatus)}
    }
}