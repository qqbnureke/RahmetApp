package com.nurda.rahmetapp.adapter

import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nurda.rahmetapp.R
import com.nurda.rahmetapp.model.Social
import kotlinx.android.synthetic.main.view_imageview.view.*

class SocialSitesAdapter(val socialSites: List<Social>) : RecyclerView.Adapter<SocialViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): SocialViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.view_imageview, parent, false)
        return SocialViewHolder(v)
    }

    override fun getItemCount(): Int {
        return socialSites.size
    }

    override fun onBindViewHolder(holder: SocialViewHolder, position: Int) {
        when (socialSites[position].networkName) {
            "fb" -> holder.image.setImageResource(R.drawable.logo_facebook)
            "ins" -> holder.image.setImageResource(R.drawable.logo_instagram)
            "vk" -> holder.image.setImageResource(R.drawable.logo_vk)
        }


        holder.setOnSocialSiteItemClickListener(object : SocialSiteItemClickListener {
            override fun onSocialSiteItemClickListener(view: View, position: Int) {
                view.context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(
                        socialSites[position].networkUrl)))
            }
        })
    }

}

class SocialViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
    val image = itemView.iv_social
    var socialSiteItemClickListener: SocialSiteItemClickListener? = null

    init {
        itemView.setOnClickListener(this)
    }

    fun setOnSocialSiteItemClickListener(itemClickListener: SocialSiteItemClickListener) {
        this.socialSiteItemClickListener = itemClickListener
    }

    override fun onClick(v: View?) {
        this.socialSiteItemClickListener?.onSocialSiteItemClickListener(v!!, adapterPosition)
    }


}

interface SocialSiteItemClickListener {
    fun onSocialSiteItemClickListener(view: View, position: Int)
}