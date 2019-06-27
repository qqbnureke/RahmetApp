package com.nurda.rahmetapp.view

import com.nurda.rahmetapp.model.*

interface IView {
    fun onDataErrorFromApi(error: String)
    fun onPicturesLoad(imagesList: List<String>)
    fun onHashtagsLoad(hashtagList: List<Hashtag>)
    fun onPhonesLoad(phoneList: List<String>)
    fun onPartnerLoad(partner: Partner)
    fun onCashbackLoad(cashback: CashbackAccount)
    fun setAddress(address: Address)
    fun onRegimeLoad(regime: Regime)
    fun onSocialSitesLoad(socialNetworks: List<Social>)
    fun onRatingLoad(rating: Rating)

    fun showProgress()
    fun hideProgress()
}