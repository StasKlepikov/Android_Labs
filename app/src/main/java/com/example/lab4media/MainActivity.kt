package com.example.lab4media

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab4media.databinding.ActivityMainBinding

lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAudio.setOnClickListener {
            val intent = Intent(this@MainActivity, AudioActivity::class.java)
            startActivity(intent)
        }
        binding.btnVideo.setOnClickListener {
            val intent = Intent(this@MainActivity, VideoActivity::class.java)
            startActivity(intent)
        }
    }

}