package com.example.lab4media

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.inflate
import android.widget.MediaController
import com.example.lab4media.databinding.ActivityVideoBinding



class VideoActivity : AppCompatActivity() {

    lateinit var binding: ActivityVideoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mediaController = MediaController(this)
        mediaController.setAnchorView(binding.video)

        //val onlineUri = Uri.parse("https://vod-progressive.akamaized.net/exp=1639775205~acl=%2Fvimeo-prod-skyfire-std-us%2F01%2F4570%2F22%2F572853732%2F2707012794.mp4~hmac=6d551a7138ba5c8087b1937c75ce937390bdbb73b4ae5b5ca79fcd77d14f5db4/vimeo-prod-skyfire-std-us/01/4570/22/572853732/2707012794.mp4?filename=Peacock+-+80687.mp4")
        val onlineUri = Uri.parse("android.resource://$packageName//${R.raw.videofile}")
        binding.video.setVideoURI(onlineUri)
        binding.video.requestFocus()
        binding.video.start()

        binding.video.setMediaController(mediaController)
        mediaController.setAnchorView(binding.video)

        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
