package com.example.forresult

import java.io.Serializable
import java.util.*

data class Person(
    var fname: String,
    var lastName: String,
    var age: Int,
    val birthDate: Date = Date()
) : Serializable {
    
}