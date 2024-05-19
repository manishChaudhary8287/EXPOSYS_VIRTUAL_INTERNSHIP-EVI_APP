package com.manish.exposys.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.manish.exposys.R

class LoginActivity : AppCompatActivity() {
    lateinit var btnLogin:Button
    lateinit var register:TextView
    lateinit var sp:SharedPreferences
    lateinit var etemail:EditText
    lateinit var etpass:EditText
    lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sp=getSharedPreferences("Exposys", Context.MODE_PRIVATE)
        val isLoggedIn =sp.getBoolean("isLoggedIn",false)
        if(isLoggedIn){
            val intent= Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        btnLogin=findViewById(R.id.btnLogin)
        register=findViewById(R.id.newUser)
        etemail=findViewById(R.id.etUsername)
        etpass=findViewById(R.id.etPassword)

        auth= FirebaseAuth.getInstance()

        btnLogin.setOnClickListener {

            val email=etemail.text.toString()
            val pass=etpass.text.toString()

            if(isAllFieldChecked())
            {
                auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(this) {
                    if(it.isSuccessful){
                        Toast.makeText(this@LoginActivity,"Login Successfully",Toast.LENGTH_SHORT)
                            .show()
                        val intent= Intent(this@LoginActivity, MainActivity::class.java)
                        sp.edit().putBoolean("isLoggedIn",true).apply()
                        startActivity(intent)
                        finish()
                    }
                    else{
                        Toast.makeText(this@LoginActivity,"Login Failed",Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }



        }
        register.setOnClickListener {
            val intent=Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
    fun isAllFieldChecked():Boolean{

        if(etemail.length()==0 || etpass.length()==0){
            if(etemail.length()==0)
            {
                etemail.error="Email is required"

            }
            if(etpass.length()==0)
            {
                etpass.error="Password is must"
            }
            Toast.makeText(this@LoginActivity,"Enter Your credentials",Toast.LENGTH_SHORT).show()
            return false
        }
        else {
            return true
        }
    }
}