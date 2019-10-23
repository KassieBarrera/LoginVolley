package com.example.forresult

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_coment_person.*

class ComentPerson : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coment_person)
        setSupportActionBar(toolbar)

        val person: Person = intent.getSerializableExtra("person") as Person
        val someValue: Int = intent.getIntExtra("somekey", 999)

        val fname: TextView = findViewById(R.id.txtName)
        val lastname: TextView = findViewById(R.id.txtLastName)
        val age: TextView = findViewById(R.id.txtAge)


        fname.text = person.fname
        lastname.text = person.lastName
        age.text = person.age.toString()

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val savebnt: Button = findViewById(R.id.save)
        val cancelbnt: Button = findViewById(R.id.cancel)

        savebnt.setOnClickListener {
            /*person.fname = "Primer nombre cambiado"
            person.lastName = "Apellido cambiado"*/

            val newPerson: Person = Person("Primer nombre cambiado", "Apellido cambiado", 10)
            val returnIntent: Intent = Intent()
            returnIntent.putExtra("rperson", newPerson)
            returnIntent.putExtra("some_newvalue", 55)
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }

        cancelbnt.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }

}
