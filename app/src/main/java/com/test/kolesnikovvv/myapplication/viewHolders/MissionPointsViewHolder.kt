package com.test.kolesnikovvv.myapplication.viewHolders

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.test.kolesnikovvv.myapplication.R

class MissionPointsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var turnNumber: TextView = itemView.findViewById(R.id.tv_turn_number)
}