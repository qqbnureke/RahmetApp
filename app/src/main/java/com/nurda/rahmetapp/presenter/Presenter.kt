package com.nurda.rahmetapp.presenter

import android.content.Context
import com.nurda.rahmetapp.api.RetrofitService
import com.nurda.rahmetapp.model.Address
import com.nurda.rahmetapp.model.RahmetResponse
import com.nurda.rahmetapp.view.IView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class Presenter(context: Context) {
    val rahmetView = context as IView

    fun getDataFromApi(id: Int) {
        RetrofitService.create()
            .getFilial(id)
            .enqueue(object : Callback<RahmetResponse> {
                override fun onFailure(call: Call<RahmetResponse>, t: Throwable) {
                    rahmetView.onDataErrorFromApi(t.localizedMessage)
                }

                override fun onResponse(call: Call<RahmetResponse>, response: Response<RahmetResponse>) {
                    rahmetView.onRatingLoad(response.body()!!.data.rating)
                    rahmetView.setAddress(response.body()!!.data.address)
                    rahmetView.onPicturesLoad(response.body()!!.data.images)
                    rahmetView.onHashtagsLoad(response.body()!!.data.hashtags)
                    rahmetView.onPhonesLoad(response.body()!!.data.phones)
                    rahmetView.onPartnerLoad(response.body()!!.data.partner)
                    rahmetView.onCashbackLoad(response.body()!!.data.rule.cashback_account)

                    val day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
                    rahmetView.onRegimeLoad(response.body()!!.data.regime[day])


                    rahmetView.onSocialSitesLoad(response.body()!!.data.partner.social_networks)

                }

            })
    }
}