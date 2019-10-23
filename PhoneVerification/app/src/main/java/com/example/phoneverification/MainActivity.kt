package com.example.phoneverification

import android.content.Intent
import android.media.AudioRecord.STATE_INITIALIZED
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.FirebaseException
import com.google.firebase.auth.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {


    private var verificationInProgress = false
    private var storedVerificationId: String? = ""
    private lateinit var auth: FirebaseAuth
    private lateinit var mAuthlistener: FirebaseAuth.AuthStateListener
    val TAG: String = "MainActivity"

    val telefono: EditText = findViewById(R.id.edtTelefono)
    val token: EditText = findViewById(R.id.edtToken)
    val btn_IngresoTelefono: Button = findViewById(R.id.IngresoTelefono)
    val btn_VerificarToken: Button = findViewById(R.id.verificar)

    lateinit var mCallbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        auth = FirebaseAuth.getInstance()
        mAuthlistener = FirebaseAuth.AuthStateListener {
            firebaseAuth ->
            val user = firebaseAuth.currentUser
            if (user!= null){
                Toast.makeText(this, "Bienvenido" + firebaseAuth.currentUser!!.providerId,
                    Toast.LENGTH_SHORT).show()
                val intent = Intent(this, NuevaActividad::class.java )
                startActivity(intent)
                finish()
            }
        }
        mCallbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                Log.d(TAG, "onVerificationCompleted:$credential")
                verificationInProgress = false
                //signInWithPhoneAuthCredential(credential)
            }

            override fun onVerificationFailed(p0: FirebaseException) {
                Toast.makeText(this@MainActivity, "onVerificationFailed", Toast.LENGTH_SHORT).show()
                   }

        }

    }


    fun requestCode(view: View) {

        if (TextUtils.isEmpty(telefono.toString())){
            return
            PhoneAuthProvider.getInstance().verifyPhoneNumber(telefono.toString(), 60, TimeUnit.SECONDS,
                this, this.mCallbacks
            )
        }
    }


}


