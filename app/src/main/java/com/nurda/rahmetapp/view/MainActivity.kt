package com.nurda.rahmetapp.view

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import com.google.android.flexbox.AlignItems
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.nurda.rahmetapp.R
import com.nurda.rahmetapp.adapter.PhonesAdapter
import com.nurda.rahmetapp.adapter.SocialSitesAdapter
import com.nurda.rahmetapp.adapter.TagsAdapter
import com.nurda.rahmetapp.adapter.ViewPagerAdapter
import com.nurda.rahmetapp.model.*
import com.nurda.rahmetapp.presenter.Presenter
import com.nurda.rahmetapp.utils.MarginItemDecoration
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_address.*
import kotlinx.android.synthetic.main.layout_contacts.*
import kotlinx.android.synthetic.main.layout_description.*
import kotlinx.android.synthetic.main.layout_partner.*
import kotlinx.android.synthetic.main.layout_rejime.*
import kotlinx.android.synthetic.main.layout_tags.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class MainActivity : AppCompatActivity(), IView {
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Presenter(this).getDataFromApi(115)
    }

    override fun onDataErrorFromApi(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
        Log.d(TAG, "onDataErrorFromApi: $error")
    }

    override fun setAddress(address: Address) {
        tv_address.text = address.address
        tv_address.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("geo:${address.coordLat},${address.coordLng}")))
        }
    }

    override fun onPicturesLoad(imagesList: List<String>) {
        view_pager.adapter = ViewPagerAdapter(this, imagesList)
    }

    override fun onHashtagsLoad(hashtagList: List<Hashtag>) {
        val flexboxLayoutManager = FlexboxLayoutManager(this).apply {
            flexWrap = FlexWrap.WRAP
            flexDirection = FlexDirection.ROW
            alignItems = AlignItems.STRETCH
        }

        recycler_view.layoutManager = flexboxLayoutManager
        recycler_view.addItemDecoration(MarginItemDecoration(10))
        recycler_view.adapter = TagsAdapter(hashtagList)
    }

    override fun onPhonesLoad(phoneList: List<String>) {
        recycler_view_contacts.layoutManager = LinearLayoutManager(this)
        recycler_view_contacts.adapter = PhonesAdapter(phoneList)
    }

    override fun onPartnerLoad(partner: Partner) {
        tv_name.text = partner.name

        Picasso.get().load(partner.logotype_url).into(iv_logo)

        tv_description.text = partner.description

        tv_website.text = partner.website_url
        tv_website.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(partner.website_url))
            startActivity(intent)
        }

        tv_partners_count.text = partner.filials.size.toString()
    }

    @SuppressLint("SetTextI18n")
    override fun onCashbackLoad(cashback: CashbackAccount) {
        tv_cashback.text = resources.getString(R.string.cashback) + "${cashback.id} %"
    }

    @SuppressLint("SetTextI18n")
    override fun onRegimeLoad(regime: Regime) {
        tv_rejim.text = "${regime.start} - ${regime.end}"
        if (regime.status == 1) {
            tv_rejim_status.text = resources.getString(R.string.opened)
            tv_rejim_status.setTextColor(resources.getColor(R.color.dark_green))
        } else {
            tv_rejim_status.text = resources.getString(R.string.opened)
            tv_rejim_status.setTextColor(resources.getColor(R.color.red))
        }
    }

    override fun onSocialSitesLoad(socialNetworks: Map<String, String>) {
        val socialSites = ArrayList<Int>()
        for (network in socialNetworks.keys) {
            when (network) {
                "fb" -> socialSites.add(R.drawable.logo_facebook)
                "ins" -> socialSites.add(R.drawable.logo_instagram)
                "vk" -> socialSites.add(R.drawable.logo_vk)
            }
        }

        recycler_view_social.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recycler_view_social.adapter = SocialSitesAdapter(socialSites)
    }
}
