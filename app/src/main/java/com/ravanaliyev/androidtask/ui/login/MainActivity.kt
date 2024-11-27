package com.ravanaliyev.androidtask.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ravanaliyev.androidtask.databinding.ActivityMainBinding
import com.ravanaliyev.androidtask.ui.home.HomeActivity
import com.ravanaliyev.androidtask.ui.register.RegisterActivity
import com.ravanaliyev.androidtask.utils.CredentialsManager

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val credentialsManager = CredentialsManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setup()
    }


    private fun setup() {
        with(binding) {
            buttonRegister.setOnClickListener {
                startActivity(Intent(this@MainActivity, RegisterActivity::class.java))
                finish()
            }
            buttonLogin.setOnClickListener {
                login()
            }
        }
    }

    private fun login() {
        with(binding) {
            val email = etEmail.text.toString()
            val pass = etPassword.text.toString()

            val loginCredentials = listOf(
                credentialsManager.validateEmail(email),
                credentialsManager.validatePassword(pass)
            )

            val hasError = loginCredentials.any { !it.isSuccess }

            if (hasError) {
                Toast.makeText(
                    this@MainActivity,
                    loginCredentials.first { it.isSuccess.not() }.errorMessage.orEmpty(),
                    Toast.LENGTH_LONG
                ).show()
                return
            }
            Toast.makeText(this@MainActivity, "Welcome.", Toast.LENGTH_LONG).show()
            startActivity(Intent(this@MainActivity, HomeActivity::class.java))
            finish()

        }

    }

}