package com.example.loginretrofit.Model

class APIResponse {
    var isError: Boolean = false
    var uid: String?= null
    var error_msg: String? = null
    var user: User? = null
}