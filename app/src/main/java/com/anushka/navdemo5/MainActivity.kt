package com.anushka.navdemo5

import android.os.Build.VERSION_CODES.R
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.anushka.navdemo5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        Log.d("LifeCycle", "onCreate: onCreate")
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
    }

    override fun onStart() {
        Log.d("LifeCycle", "onStart: onStart")
        super.onStart()
    }


    override fun onResume() {
        Log.d("LifeCycle", "onResume: onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d("LifeCycle", "onPause: onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d("LifeCycle", "onStop: onStop")
        super.onStop()
    }

    override fun onRestart() {
        Log.d("LifeCycle", "onRestart: onRestart")
        super.onRestart()
    }

    override fun onDestroy() {
        Log.d("LifeCycle", "onDestroy: onDestroy")
        super.onDestroy()
    }
}
