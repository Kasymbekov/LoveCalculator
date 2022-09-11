package com.example.lovecalculator.network

import com.google.gson.annotations.SerializedName

data class LoveModel(

    @SerializedName("fname")
    val firstName: String,
    @SerializedName("sname")
    val secondName: String,
    val percentage: String,
    val result: String,
)
