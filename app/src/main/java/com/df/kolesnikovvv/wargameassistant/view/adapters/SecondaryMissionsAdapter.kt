package com.df.kolesnikovvv.wargameassistant.view.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import com.df.kolesnikovvv.wargameassistant.R
import com.df.kolesnikovvv.wargameassistant.entity.GamePoints
import com.df.kolesnikovvv.wargameassistant.entity.MissionMeterElement
import com.df.kolesnikovvv.wargameassistant.entity.SecondaryMissionVp
import com.df.kolesnikovvv.wargameassistant.entity.TurnVp
import com.df.kolesnikovvv.wargameassistant.textWatchers.MissionMeterEtTw


class SecondaryMissionsAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_SEC_MISSION: Int = 0
    private val TYPE_VP_TURN    : Int = 1
    private var itemList: ArrayList<MissionMeterElement> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        when (viewType) {
            TYPE_SEC_MISSION -> {
                val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_sec_mission_vp, parent, false)
                return SecondaryMissionsViewHolder(view)
            }
            TYPE_VP_TURN -> {
                val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_turn_vp, parent, false)
                return TurnVpViewHolder(view)
            }
        }
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_sec_mission_vp, parent, false)
        return SecondaryMissionsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val element: MissionMeterElement? = getItem(position)
        val type: Int = getItemViewType(position)

        when(type) {
            TYPE_SEC_MISSION    -> {
                bindSecMissionHolder(holder as SecondaryMissionsViewHolder, element as SecondaryMissionVp)
            }
            TYPE_VP_TURN        -> {
                bindVpTurnHolder(holder as TurnVpViewHolder, element as TurnVp)
            }
        }
    }

    private fun bindSecMissionHolder(holder: SecondaryMissionsViewHolder, element: SecondaryMissionVp) {
        holder.missionName.text = element.missionName
        holder.myStatus.isChecked = element.myStatus
        holder.oppStatus.isChecked = element.oppStatus

        holder.myStatus.setOnClickListener {
            if (GamePoints.mySecVp[element.missionIndex] == 1) {
                GamePoints.mySecVp[element.missionIndex] = 0
            }
            else
                GamePoints.mySecVp[element.missionIndex] = 1


        }

        holder.oppStatus.setOnClickListener {
            if (GamePoints.oppSecVp[element.missionIndex] == 1) {
                GamePoints.oppSecVp[element.missionIndex] = 0
            }
            else
                GamePoints.oppSecVp[element.missionIndex] = 1
        }
    }

    private fun bindVpTurnHolder(holder: TurnVpViewHolder, element: TurnVp) {
        holder.name.text = "Ход " + element.turnIndex.toString()
        holder.myVp.setText(element.myVp)
        holder.oppVp.setText(element.oppVp)

        holder.myVp.addTextChangedListener(MissionMeterEtTw(true, element.turnIndex))
        holder.oppVp.addTextChangedListener(MissionMeterEtTw(false, element.turnIndex))
    }

    override fun getItemViewType(position: Int): Int {
        val element: MissionMeterElement? = getItem(position)
        when (element?.type) {
            MissionMeterElement.Type.SEC_MISSION -> return TYPE_SEC_MISSION
            MissionMeterElement.Type.TURN_VP -> return TYPE_VP_TURN
        }
        return TYPE_SEC_MISSION
    }

    private fun getItem(position: Int): MissionMeterElement? {
        if (position < 0 || position >= itemList.size)
            return null

        return itemList[position]
    }

    fun setData(elements: List<MissionMeterElement>) {
        itemList.clear()
        itemList.addAll(elements)
    }

    fun addItems(elements: List<MissionMeterElement>) {
        itemList.addAll(elements)
    }


    class TurnVpViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.tv_turn)
        val myVp: EditText = itemView.findViewById(R.id.et_my_vp)
        val oppVp: EditText = itemView.findViewById(R.id.et_opp_vp)
    }

    class SecondaryMissionsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val missionName: TextView = itemView.findViewById(R.id.sec_mission_name)
        val myStatus: CheckBox = itemView.findViewById(R.id.cb_my_status)
        val oppStatus: CheckBox = itemView.findViewById(R.id.cb_opp_status)
    }
}