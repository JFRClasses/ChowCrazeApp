package com.example.chowcrazeapp.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.chowcrazeapp.MainActivity
import com.example.chowcrazeapp.R
import com.example.chowcrazeapp.mock.MockData
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {
    private lateinit var loginBtn : Button
    private lateinit var emailET : EditText
    private lateinit var passwordET : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        val sharedPreferences = getSharedPreferences("mypref", MODE_PRIVATE)
        val isLogged = sharedPreferences.getBoolean("isLogged",false)
        if(isLogged){
            val intent = Intent(this@LoginActivity,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        loginBtn = findViewById(R.id.loginBtn)
        emailET = findViewById(R.id.emailET)
        passwordET = findViewById(R.id.passwordET)
        loginBtn.setOnClickListener {
            Log.i("INGENIERIASOFT","Boton presionado")
            val email = emailET.text.toString()
            val password = passwordET.text.toString()
            if(email.isEmpty() || password.isEmpty()){
                Log.i("Invalid","Invalid data")
                Snackbar.make(it,"El correo o contraseña estan vacions", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val isValidUser = MockData.users.any{ u-> u.email == email && u.password == password}
            if(!isValidUser){
                Snackbar.make(it,"El correo o la contraseña no son validos", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val editor = sharedPreferences.edit()
            editor.putBoolean("isLogged",true)
            editor.apply()
            val intent = Intent(this@LoginActivity,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}