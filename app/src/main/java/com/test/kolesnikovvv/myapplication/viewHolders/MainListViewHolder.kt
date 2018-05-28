package com.test.kolesnikovvv.myapplication.viewHolders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.test.kolesnikovvv.myapplication.R

class MainListViewHolder(row: View?) {
    val name: TextView = row?.findViewById(R.id.tv_element_name) as TextView
    val stats: TextView = row?.findViewById(R.id.tv_element_text) as TextView
    val img: ImageView = row?.findViewById(R.id.iv_element_icon) as ImageView

}