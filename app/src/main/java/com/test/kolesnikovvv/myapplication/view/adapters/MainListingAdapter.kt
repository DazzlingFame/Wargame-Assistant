package com.test.kolesnikovvv.myapplication.view.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.test.kolesnikovvv.myapplication.R
import com.test.kolesnikovvv.myapplication.entity.Unit
import com.test.kolesnikovvv.myapplication.view.viewHolders.MainListViewHolder

class MainListingAdapter(private val myDataset: ArrayList<Unit>, private val clickListener: (Unit) -> kotlin.Unit) :
        RecyclerView.Adapter<MainListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainListViewHolder {

        val element: View = LayoutInflater.from(parent.context).inflate(R.layout.element_main_listing, parent, false)

        return MainListViewHolder(element)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MainListViewHolder, position: Int) {
        holder.name.text = myDataset[position].name
        holder.stats.text = myDataset[position].stats
        holder.img.setImageResource(myDataset[position].image)
    }

    override fun getItemCount() = myDataset.size

    override fun onBindViewHolder(holder: MainListViewHolder, position: Int, payloads: MutableList<Any>) {
//        super.onBindViewHolder(holder, position, payloads)
        holder.bind(myDataset[position], clickListener)
    }

}