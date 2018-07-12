package com.df.kolesnikovvv.wargameassistant.view.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.df.kolesnikovvv.wargameassistant.R
import com.df.kolesnikovvv.wargameassistant.entity.Unit

class MainListingAdapter(private val myDataset: ArrayList<Unit>, private val clickListener: (Unit) -> kotlin.Unit) :
        RecyclerView.Adapter<MainListingAdapter.MainListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainListViewHolder {

        val element: View = LayoutInflater.from(parent.context).inflate(R.layout.item_main_listing, parent, false)

        return MainListViewHolder(element)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MainListViewHolder, position: Int) {
        holder.bind(myDataset[position], clickListener)
    }

    override fun getItemCount() = myDataset.size

    override fun onBindViewHolder(holder: MainListViewHolder, position: Int, payloads: MutableList<Any>) {
//        super.onBindViewHolder(holder, position, payloads)
        holder.bind(myDataset[position], clickListener)
    }

    class MainListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.tv_element_name) as TextView
        val stats: TextView = itemView.findViewById(R.id.tv_element_text) as TextView
        val img: ImageView = itemView.findViewById(R.id.iv_element_icon) as ImageView

        fun bind(unitData: Unit, clickListener: (Unit) -> kotlin.Unit) {
            name.text = unitData.name
            stats.text = unitData.stats
            img.setImageResource(unitData.image)
            itemView.setOnClickListener {
                clickListener(unitData)
            }
        }

    }

}