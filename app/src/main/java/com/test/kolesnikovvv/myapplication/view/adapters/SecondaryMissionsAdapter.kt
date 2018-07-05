package com.test.kolesnikovvv.myapplication.view.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.test.kolesnikovvv.myapplication.R
import com.test.kolesnikovvv.myapplication.entity.SecondaryMissionVp
import com.test.kolesnikovvv.myapplication.view.viewHolders.SecondaryMissionsViewHolder

class SecondaryMissionsAdapter (private val myDataset: ArrayList<SecondaryMissionVp>, private val clickListener: (SecondaryMissionVp) -> kotlin.Unit) : RecyclerView.Adapter<SecondaryMissionsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondaryMissionsViewHolder {

        val element: View = LayoutInflater.from(parent.context).inflate(R.layout.item_sec_mission_vp, parent, false)

        return SecondaryMissionsViewHolder(element)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: SecondaryMissionsViewHolder, position: Int) {
        holder.bind(myDataset[position], clickListener)
    }

    override fun getItemCount() = myDataset.size

    override fun onBindViewHolder(holder: SecondaryMissionsViewHolder, position: Int, payloads: MutableList<Any>) {
//        super.onBindViewHolder(holder, position, payloads)
        holder.bind(myDataset[position], clickListener)
    }
}