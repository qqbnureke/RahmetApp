package com.nurda.rahmetapp.view

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
import com.nurda.rahmetapp.model.Address
import com.nurda.rahmetapp.model.Data
import com.nurda.rahmetapp.presenter.Presenter
import com.nurda.rahmetapp.utils.MarginItemDecoration
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

        val name = "Rumi"
        val cashback = "Кэшбэк 5%"
        val logo = R.drawable.rumi_logo

        val description = resources.getString(R.string.description_text)
        val rejim = "10:00 - 23:59"
        val rejim_status = "Открыто"
        val partners_count = "5"
        val url = "http://www.plov.kz/"

        val list = ArrayList<String>()
        list.add("Узбекская кухня")
        list.add("Поесть")
        list.add("Кафе")
        list.add("Ресторан")

        val phones = ArrayList<String>()
        phones.add("+7 (701) 808-0111")
        phones.add("+7 (272) 346-9142")

        val social_sites = ArrayList<Int>()
        social_sites.add(R.drawable.logo_facebook)
        social_sites.add(R.drawable.logo_instagram)
        social_sites.add(R.drawable.logo_twitter)
        social_sites.add(R.drawable.logo_youtube)
        social_sites.add(R.drawable.logo_vk)

        val listImage = ArrayList<Int>()
        listImage.add(R.drawable.rumi1)
        listImage.add(R.drawable.rumi2)
        listImage.add(R.drawable.rumi3)



        tv_name.text = name
        tv_cashback.text = cashback
        iv_logo.setImageResource(logo)

        //tv_address.text = address
        tv_description.text = description
        tv_rejim.text = rejim
        tv_rejim_status.text = rejim_status
        tv_partners_count.text = partners_count

        view_pager.adapter = ViewPagerAdapter(this, listImage)

        val flexboxLayoutManager = FlexboxLayoutManager(this).apply {
            flexWrap = FlexWrap.WRAP
            flexDirection = FlexDirection.ROW
            alignItems = AlignItems.STRETCH
        }

        recycler_view.layoutManager = flexboxLayoutManager
        recycler_view.addItemDecoration(MarginItemDecoration(10))
        recycler_view.adapter = TagsAdapter(list)

        recycler_view_contacts.layoutManager = LinearLayoutManager(this)
        recycler_view_contacts.adapter = PhonesAdapter(phones)


        tv_website.text = url
        tv_website.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        recycler_view_social.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recycler_view.addItemDecoration(MarginItemDecoration(5))
        recycler_view_social.adapter = SocialSitesAdapter(social_sites)

        Presenter(this).getDataFromApi(115)
    }

    override fun onDataCompleteFromApi(data: Data) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDataErrorFromApi(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
        Log.d(TAG, "onDataErrorFromApi: $error")
    }

    override fun setAddress(address: Address) {
        tv_address.text = address.address
    }
}
