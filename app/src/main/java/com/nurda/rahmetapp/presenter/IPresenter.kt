package com.nurda.rahmetapp.presenter

interface IPresenter {
    fun onDestroy()
    fun requestDataFromApi(id : Int)
}