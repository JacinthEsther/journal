package com.example.myjournal.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
       val baseUrl = "http://gossip-central-dev.herokuapp.com/api/v1/"

    private fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val gossipCentralAPI: GossipCentralAPI = getInstance()
        .create(GossipCentralAPI::class.java)
}