package com.test.kolesnikovvv.myapplication.view.viewHolders

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.test.kolesnikovvv.myapplication.R
import com.test.kolesnikovvv.myapplication.entity.TurnVp
import com.test.kolesnikovvv.myapplication.textWatchers.MissionMeterEtTw

class TurnVpViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val name: TextView = itemView.findViewById(R.id.tv_turn) as TextView
    val myVp: EditText = itemView.findViewById(R.id.et_my_vp)
    val oppVp: EditText = itemView.findViewById(R.id.et_opp_vp)

    fun bind(turnData: TurnVp) {
        name.text = "Ход " + turnData.turnIndex.toString()
        myVp.setText(turnData.myVp)
        oppVp.setText(turnData.oppVp)

        myVp.addTextChangedListener(MissionMeterEtTw(true, turnData.turnIndex))
        oppVp.addTextChangedListener(MissionMeterEtTw(false, turnData.turnIndex))
    }
}