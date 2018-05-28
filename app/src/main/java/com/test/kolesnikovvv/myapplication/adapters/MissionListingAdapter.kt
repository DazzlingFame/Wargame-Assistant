package com.test.kolesnikovvv.myapplication.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.test.kolesnikovvv.myapplication.R
import com.test.kolesnikovvv.myapplication.objects.TurnPoints
import com.test.kolesnikovvv.myapplication.viewHolders.MissionPointsViewHolder

class MissionListingAdapter(private val myDataset: ArrayList<TurnPoints>) :
        RecyclerView.Adapter<MissionPointsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MissionPointsViewHolder {

        val element: View = LayoutInflater.from(parent.context).inflate(R.layout.element_mission_meter, parent, false)

        return MissionPointsViewHolder(element)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MissionPointsViewHolder, position: Int) {
        holder.turnNumber.text = myDataset[position].turnNumber.toString()
    }

    override fun getItemCount() = myDataset.size

}