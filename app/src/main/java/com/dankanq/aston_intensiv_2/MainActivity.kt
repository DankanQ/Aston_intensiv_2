package com.dankanq.aston_intensiv_2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.dankanq.aston_intensiv_2.Utils.bind

class MainActivity : AppCompatActivity() {
    private val buttonHelloToastActivity by bind<Button>(R.id.button_hello_toast)
    private val buttonScrollViewActivity by bind<Button>(R.id.button_scroll_view)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(LOG_TAG, "onCreate")

        setOnClickListeners()
    }

    override fun onStart() {
        super.onStart()

        Log.d(LOG_TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()

        Log.d(LOG_TAG, "onResume")
    }

    override fun onStop() {
        super.onStop()

        Log.d(LOG_TAG, "onStop")
    }

    override fun onRestart() {
        super.onRestart()

        Log.d(LOG_TAG, "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d(LOG_TAG, "onDestroy")
    }

    private fun setOnClickListeners() {
        buttonHelloToastActivity.setOnClickListener { launchHelloToastActivity() }
        buttonScrollViewActivity.setOnClickListener { launchScrollViewActivity() }
    }

    private fun launchHelloToastActivity() {
        val intent = Intent(this, HelloToastActivity::class.java)
        startActivity(intent)
    }

    private fun launchScrollViewActivity() {
        val intent = Intent(this, ScrollViewActivity::class.java)
        startActivity(intent)
    }

    companion object {
        private val LOG_TAG = MainActivity::class.java.simpleName
    }
}