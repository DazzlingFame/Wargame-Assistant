package com.test.kolesnikovvv.myapplication.viewHolders

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.test.kolesnikovvv.myapplication.R
import com.test.kolesnikovvv.myapplication.objects.Unit

class MainListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val name: TextView = itemView.findViewById(R.id.tv_element_name) as TextView
    val stats: TextView = itemView.findViewById(R.id.tv_element_text) as TextView
    val img: ImageView = itemView.findViewById(R.id.iv_element_icon) as ImageView

    fun bind(unitData: Unit, clickListener: (Unit) -> kotlin.Unit) {
        name.text = unitData.name
        stats.text = unitData.stats
        img.setImageResource(unitData.image)
        itemView.setOnClickListener {clickListener(unitData)}
    }

}