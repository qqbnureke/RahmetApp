package com.nurda.rahmetapp.view

import com.nurda.rahmetapp.model.Address
import com.nurda.rahmetapp.model.Data

interface IView {
    fun onDataCompleteFromApi(data: Data)
    fun onDataErrorFromApi(error: String)
    fun setAddress(address: Address)
}