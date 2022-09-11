package com.example.lovecalculator.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {

    @GET("getPercentage")
    fun calculateLove(
        @Header("X-RapidAPI-Key") key: String = "b3e168c737msh4366de8d69d65cdp1eef04jsn0427382d176d",
        @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com",
        @Query("sname") secondName: String,
        @Query("fname") firstName: String
    ): Call<LoveModel>
}