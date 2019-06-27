package com.nurda.rahmetapp.api

import com.nurda.rahmetapp.model.RahmetResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {

    @GET("partner/v2/filials/card/id/{filial_id}")
    fun getFilial(@Path("filial_id") id: Int): Call<RahmetResponse>

    companion object {
        fun create(): RetrofitService {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://gateway.choco.kz/")
                .build()

            return retrofit.create(RetrofitService::class.java)
        }
    }
}