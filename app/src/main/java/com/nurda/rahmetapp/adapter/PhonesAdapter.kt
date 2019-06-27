package com.nurda.rahmetapp.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nurda.rahmetapp.R
import kotlinx.android.synthetic.main.view_textview.view.*

class PhonesAdapter(val phoneList: List<String>) : RecyclerView.Adapter<PhoneViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): PhoneViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.view_textview, parent, false)
        return PhoneViewHolder(v)
    }

    override fun getItemCount(): Int {
        return phoneList.size
    }

    override fun onBindViewHolder(holder: PhoneViewHolder, position: Int) {
        holder.tv_phone.text = phoneList[position]
    }

}

class PhoneViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tv_phone = itemView.tv_phone
}