package com.nurda.rahmetapp.adapter

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nurda.rahmetapp.R
import kotlinx.android.synthetic.main.view_button.view.*

class TagsAdapter(val tagList: ArrayList<String>) : RecyclerView.Adapter<TagViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): TagViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.view_button, parent, false)
        return TagViewHolder(v)
    }

    override fun onBindViewHolder(holder: TagViewHolder, position: Int) {
        holder.btnTag.text = tagList[position]
    }

    override fun getItemCount(): Int {
        return tagList.size
    }


}

class TagViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val btnTag = itemView.btn_tag
}


//override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
//    val v = LayoutInflater.from(parent.context).inflate(R.layout.view_button, parent, false)
//    return ViewHolder(v)
//}
//
//override fun getItemCount(): Int {
//    return tagList.size
//}
//
//override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//    holder.btnTag.text = tagList[position]
//}
