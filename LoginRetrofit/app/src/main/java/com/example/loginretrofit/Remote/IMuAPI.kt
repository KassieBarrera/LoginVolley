package com.example.loginretrofit.Remote

import android.net.DnsResolver
import com.example.loginretrofit.Model.APIResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface IMuAPI {
    @FormUrlEncoded
    @POST("register.php")
    fun registrerUsert(@Field("name") name:String, @Field("email") email: String,
                       @Field("password") password: String): Call<APIResponse>

    @FormUrlEncoded
    @POST("login.php")
    fun login( @Field("email") email: String,@Field("password") password: String): Call<APIResponse>

}