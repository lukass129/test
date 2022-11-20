package com.example.myapplication55

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication55.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        val names = listOf(
            "Vadim",
            "Taras",
            "Ivan",
            "Maksim",
            "Mikhail"
        )
        val adapter = Adapter(names)
        binding.recyclerView.adapter = adapter
    }

}