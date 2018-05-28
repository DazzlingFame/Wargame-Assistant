package com.test.kolesnikovvv.myapplication.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.test.kolesnikovvv.myapplication.R
import com.test.kolesnikovvv.myapplication.objects.Unit
import com.test.kolesnikovvv.myapplication.viewHolders.MainListViewHolder

class MainListingAdapter(context: Context, items: ArrayList<Unit>): BaseAdapter() {
    var lInflater: LayoutInflater
    var objects: ArrayList<Unit>

    init {
        objects = items
        lInflater = LayoutInflater.from(context)
    }

    override fun getCount(): Int {
        return objects.size
    }

    override fun getItem(position: Int): Any {
        return objects[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        val view: View?
        val vh: MainListViewHolder
        if (convertView == null) {
            view = this.lInflater.inflate(R.layout.element_main_listing, parent, false)
            vh = MainListViewHolder(view)
            view.tag = vh
        }
        else {
            view = convertView
            vh = view.tag as MainListViewHolder
        }

        vh.name.text = objects[position].name
        vh.stats.text = objects[position].stats
        vh.img.setImageResource(objects[position].image)
        return view
    }
}