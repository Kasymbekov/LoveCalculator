package com.example.lovecalculator

import android.app.Application
import com.example.lovecalculator.network.LoveApi
import com.example.lovecalculator.network.RetrofitService

class App: Application() {

    companion object {
        lateinit var api: LoveApi
    }

    override fun onCreate() {
        super.onCreate()
        val retrofitService = RetrofitService()
        api = retrofitService.getApi()
    }
}