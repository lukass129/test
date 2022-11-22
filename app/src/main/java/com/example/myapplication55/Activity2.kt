package com.example.myapplication55

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication55.databinding.Activity2Binding
import com.example.myapplication55.databinding.ActivityMainBinding

class Activity2 : AppCompatActivity() {
    lateinit var binding: Activity2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val position = intent.getIntExtra("data", 1)
        binding.textView.setText("you have clicked on an item at position $position")
    }
}