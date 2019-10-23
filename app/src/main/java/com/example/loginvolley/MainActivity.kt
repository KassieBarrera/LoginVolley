package com.example.loginvolley

import android.app.Activity
import android.app.DownloadManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import cq.json.JsonObject

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.card.*
import org.json.JSONArray
import org.json.JSONObject
import java.lang.reflect.Method

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class MainActivity(var adaptador: Adaptador? = null) : AppCompatActivity() {
    /*NOT FOUND */
    val url = "https://serviciowebintecap.000webhostapp.com/sw.php"
    var mPersonList = ArrayList<Persona>()

    lateinit var mPersona: Persona

    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       /* val jsonObj = JSONObject()

       esto no va


        jsonObj.put("nombre", nombr.text)
        jsonObj.put("contrasenia", telefono.text)
        jsonObj.put("direccion", direccion.text) */

        val que = Volley.newRequestQueue(this@MainActivity)
        val req = JsonObjectRequest(Request.Method.GET, url, null,
            Response.Listener { response ->

                val json: JSONArray = response.optJSONArray("clientes")
                for (i in 0 until json.length()) {
                    mPersona = Persona()
                    val jsonObject: JsonObject? = null
                    val item = json.getJSONObject(i)

                    mPersona.setNombre(item.optString("nombre"))
                    mPersona.setTelefono(item.optString("telefono"))
                    mPersona.setDireccino(item.optString("direccion"))

                    mPersonList.add(mPersona)

                    // Toast.makeText(this, response.toString(), Toast.LENGTH_SHORT).show()

                }
                adaptador = Adaptador(this, mPersonList)
                gridView.adapter = adaptador

            }, Response.ErrorListener {
                Toast.makeText(this, "Algo salio mal", Toast.LENGTH_SHORT).show()
                Log.d(TAG, "peliculas: Error.... no se pudo conectar!")
            })
        que.add(req)
    }

    /*fun post(mainActivity: Activity?, Baseurl: String,
             path: String,
             data: Map<String, String>) {
        val requestQueue = Volley.newRequestQueue(mainActivity?.applicationContext)
        val jsonObject = JSONObject(data)_response.value=""
        val stringRequest = object : StringRequest(Method.POST, "$Baseurl/$path",
            Response.Listener {
                try {
                    val json = JSONObject(it)
                    setResponse(json.toString())
                }catch (e:JsonParseException){
                    setResponse(it)
                }
                _response.value = "Response is: $it"
            },
            Response.ErrorListener {
                _response.value = "Response is: $it"
            }) {
            override fun getParams(): Map<String, String> {
                return data
            }

        }.setRetryPolicy(
            DefaultRetryPolicy(
                15000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
            )
        )
        val request = StringRequest(Request.Method.POST,"$Baseurl/$path",Response.Listener {
            _response.value = "Response is: $it"
        },Response.ErrorListener {
            _response.value = "Response is: $it"

            val stringRequest = object : JsonObjectRequest(Method.POST, "$Baseurl/$path", jsonObject,

        })

        requestQueue.add(stringRequest)
    }*/
}
