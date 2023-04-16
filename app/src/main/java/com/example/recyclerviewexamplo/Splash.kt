package com.example.recyclerviewexamplo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.VideoView

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val videoView = findViewById<VideoView>(R.id.videoView)
        val videoUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.intro)
        videoView.setVideoURI(videoUri)

        videoView.setOnCompletionListener {
            videoView.start()
        }

        videoView.start()

        Handler().postDelayed({
            val intent = Intent(this,Inicio::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}