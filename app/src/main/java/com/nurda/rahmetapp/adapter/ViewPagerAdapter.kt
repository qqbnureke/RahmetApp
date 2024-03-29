package com.nurda.rahmetapp.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nurda.rahmetapp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_viewpager.view.*

class ViewPagerAdapter(private val context: Context, val imageList: List<String>) : PagerAdapter() {

    private var layoutInflater: LayoutInflater? = null

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return imageList.size
    }

    @SuppressLint("SetTextI18n", "InflateParams")
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val v = layoutInflater!!.inflate(R.layout.layout_viewpager, null)
        Picasso.get().load(imageList[position]).into(v.iv_images)
        v.tv_image_position.text = "${position + 1}/${imageList.size}"

        val vp = container as ViewPager
        vp.addView(v, 0)
        return v
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val vp = container as ViewPager
        val v = `object` as View
        vp.removeView(v)
    }
}