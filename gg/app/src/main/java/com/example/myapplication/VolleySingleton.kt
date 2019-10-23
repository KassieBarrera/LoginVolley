package com.example.myapplication

import android.app.Application
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

class VolleySingleton : Application() {

    override fun onCreate() {
        super.onCreate()

        instance = this
    }

    val requestQueue: RequestQueue? = null

    get() {
        if (field == null){
            return Volley.newRequestQueue(applicationContext)
        }
        return field
    }

    fun <T> addToRequestQueue(reques: Request<T>){
        reques.tag = TAG
        requestQueue?.add(reques)
    }

    companion object{
        private val TAG = VolleySingleton::class.java
        @get:Synchronized var instance: VolleySingleton? = null
        private set
    }
}