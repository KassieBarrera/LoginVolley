package com.example.forresult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn: Button = findViewById(R.id.send)
        val fname: EditText = findViewById(R.id.name)
        val lastname: EditText = findViewById(R.id.lastname)
        val age: EditText = findViewById(R.id.age)

        btn.setOnClickListener {
            val person: Person = Person(
                fname.text.toString(), lastname.text.toString(),
                age.text.toString().toInt(), Date()
            )

            val intent = Intent(this, ComentPerson::class.java)
            intent.putExtra("person", person)
            intent.putExtra("somekey", 10)

            startActivityForResult(intent, 12)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data != null) {
            if (resultCode == Activity.RESULT_OK) {
                val returnP: Person = data.getSerializableExtra("rperson") as Person
                Log.d("EA", returnP.toString())
            } else if (resultCode == Activity.RESULT_CANCELED)
                Log.d("EA", "User Canceled")

        }
    }
}
