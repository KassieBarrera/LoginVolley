package com.example.loginretrofit.Common

import com.example.loginretrofit.Remote.IMuAPI
import com.example.loginretrofit.Remote.RetrofitClient
import retrofit2.create

object Common {

    const val BASE_URL = "https://serviciowebintecap.000webhostapp.com/sw.php"
    val api: IMuAPI
    get() = RetrofitClient.getClient(BASE_URL).create(IMuAPI::class.java)
}