package com.example.lab4media

import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.lab4media.databinding.ActivityAudioBinding
import java.io.IOException


class AudioActivity : AppCompatActivity() {

    lateinit var binding: ActivityAudioBinding
    var mediaPlayer: MediaPlayer = MediaPlayer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAudioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnPlay.setOnClickListener { playAudio() }
        binding.btnStop.setOnClickListener { stopAudio() }
        val audioUrl = "https://s4.xn--41a.wiki/10/52770_9380100b69a2d7be59a0994974f3ca3a.mp3?filename=muzyka-dlya-fona_-_skazochnaya-muzyka.mp3"
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)
        mediaPlayer.setDataSource(audioUrl)
        mediaPlayer.prepare()

        val actionbar = supportActionBar

        //set back button
        actionbar!!.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
    }

    private fun playAudio() {
        try {
            if (!mediaPlayer.isPlaying) {

                mediaPlayer.start()
                Toast.makeText(this, "Start", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, "Music is already playing", Toast.LENGTH_SHORT).show()
            }
        }catch (e: IOException){
            e.printStackTrace()
        }
    }

    private fun stopAudio() {
        if (mediaPlayer.isPlaying) {
            mediaPlayer.pause()
            Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Music is already stopped", Toast.LENGTH_SHORT).show()
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}