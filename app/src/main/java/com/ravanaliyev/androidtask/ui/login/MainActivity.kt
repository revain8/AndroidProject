package com.ravanaliyev.androidtask.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ravanaliyev.androidtask.databinding.ActivityMainBinding
import com.ravanaliyev.androidtask.ui.register.RegisterActivity

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonRegister.setOnClickListener {
            startActivity(Intent(this@MainActivity,RegisterActivity::class.java))
            finish()
        }

    }
}