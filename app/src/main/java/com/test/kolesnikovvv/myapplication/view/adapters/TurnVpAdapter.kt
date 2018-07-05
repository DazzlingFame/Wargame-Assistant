package com.test.kolesnikovvv.myapplication.view.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.test.kolesnikovvv.myapplication.R
import com.test.kolesnikovvv.myapplication.entity.TurnVp
import com.test.kolesnikovvv.myapplication.view.viewHolders.TurnVpViewHolder

class TurnVpAdapter (private val myDataset: ArrayList<TurnVp>): RecyclerView.Adapter<TurnVpViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TurnVpViewHolder {

        val element: View = LayoutInflater.from(parent.context).inflate(R.layout.item_turn_vp, parent, false)

        return TurnVpViewHolder(element)
    }

    override fun getItemCount() = myDataset.size

    override fun onBindViewHolder(holder: TurnVpViewHolder, position: Int) {
        holder.bind(myDataset[position])
    }

    override fun onBindViewHolder(holder: TurnVpViewHolder, position: Int, payloads: MutableList<Any>) {
        holder.bind(myDataset[position])
    }

}