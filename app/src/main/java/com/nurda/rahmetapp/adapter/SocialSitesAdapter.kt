package com.nurda.rahmetapp.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nurda.rahmetapp.R
import kotlinx.android.synthetic.main.view_imageview.view.*

class SocialSitesAdapter(val imageList:ArrayList<Int>) : RecyclerView.Adapter<SocialViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): SocialViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.view_imageview, parent, false)
        return SocialViewHolder(v)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: SocialViewHolder, position: Int) {
        holder.image.setImageResource(imageList[position])
    }

}

class SocialViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val image = itemView.iv_social
}