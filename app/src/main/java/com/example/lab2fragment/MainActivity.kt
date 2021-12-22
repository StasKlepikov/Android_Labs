package com.example.lab2fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.lab2fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.placeHolder, FragmentCalc.newInstance())
            .commit()

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.placeHolder2, FragmentRes.newInstance())
            .commit()

    }
}