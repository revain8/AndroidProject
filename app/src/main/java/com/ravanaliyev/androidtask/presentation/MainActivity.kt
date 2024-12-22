package com.ravanaliyev.androidtask.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ravanaliyev.androidtask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}