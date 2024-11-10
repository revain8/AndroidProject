package com.ravanaliyev.androidtask.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ravanaliyev.androidtask.R
import com.ravanaliyev.androidtask.databinding.ActivityRegisterBinding
import com.ravanaliyev.androidtask.ui.login.MainActivity

class RegisterActivity : AppCompatActivity() {

    private val binding by lazy { ActivityRegisterBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.buttonLogin.setOnClickListener {
            startActivity(Intent(this@RegisterActivity,MainActivity::class.java))
            finish()
        }
    }
}