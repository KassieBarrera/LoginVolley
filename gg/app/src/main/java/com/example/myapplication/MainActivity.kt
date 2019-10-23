package com.example.myapplication

import android.app.ProgressDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import org.json.JSONObject
import java.lang.reflect.Method

class MainActivity : AppCompatActivity() {

    private var editTextName: EditText? = null
    private var editTextPass: EditText? = null

    private var button: Button? = null

   // private var pd: ProgressDialog? = null
    private val URL = "https://serviciowebintecap.000webhostapp.com/sw.php"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      //  pd = ProgressDialog(this@MainActivity)


        editTextName = findViewById<EditText>(R.id.username)
        editTextPass = findViewById<EditText>(R.id.password)
        button = findViewById<Button>(R.id.btnLogin)

        button?.setOnClickListener {
            sendData()
        }
    }

    private fun sendData() {

        val stringRequest =  object: StringRequest(Method.POST, URL,
            Response.Listener<String> { response ->
             //   pd!!.dismiss()

                val obj = JSONObject(response)
                Toast.makeText(applicationContext, obj.getString("nombre"), Toast.LENGTH_SHORT)
                    .show()

            }, Response.ErrorListener {
                Toast.makeText(applicationContext, "Un error ha ocurrido", Toast.LENGTH_SHORT)
                    .show()

            }) {

            override fun getParams(): MutableMap<String, String> {
                val params = HashMap<String, String>()

                params.put("name", editTextName?.text.toString())
                params.put("position", editTextPass?.text.toString())


                return params
            }
        }
        VolleySingleton.instance!!.addToRequestQueue(stringRequest)
    }

}
