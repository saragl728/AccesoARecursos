package com.example.accesoarecursos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.accesoarecursos.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    public lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        val screenSplash = installSplashScreen()
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        screenSplash.setKeepOnScreenCondition{true}

        //hace una pausa de 4 segundos
        Thread.sleep(4000)

        //inicia la actividad principal
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}