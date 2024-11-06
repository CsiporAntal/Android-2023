package com.tasty.recipesapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.tasty.recipesapp.databinding.ActivitySplashBinding
import kotlinx.coroutines.*

class Splash : AppCompatActivity() {

    companion object {
        private const val TAG = "SplashActivity"
        private const val SPLASH_TIME_OUT: Long = 2000 // 2 seconds
    }

    private lateinit var binding: ActivitySplashBinding
    private val splashScope = CoroutineScope(Dispatchers.Main + Job())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inflate the layout using View Binding
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG, "onCreate: SplashActivity created.")

        // Optional: Initialize UI elements or animations here

        // Launch a coroutine to delay and navigate
        splashScope.launch {
            delay(SPLASH_TIME_OUT)
            navigateToMain()
        }
    }

    private fun navigateToMain() {
        // Create an Intent to start MainActivity
        val intent = Intent(this@Splash, MainActivity::class.java)
        startActivity(intent)
        // Finish SplashActivity so the user cannot return to it
        finish()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: SplashActivity started.")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: SplashActivity resumed.")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: SplashActivity paused.")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: SplashActivity stopped.")
    }

    override fun onDestroy() {
        super.onDestroy()
        // Cancel the coroutine to prevent memory leaks
        splashScope.cancel()
        Log.d(TAG, "onDestroy: SplashActivity destroyed.")
    }
}
