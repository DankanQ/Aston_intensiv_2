package com.dankanq.aston_intensiv_2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.dankanq.aston_intensiv_2.Utils.bind

class HelloToastResultActivity : AppCompatActivity() {
    private val textViewCount by bind<TextView>(R.id.text_view_count_result)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello_toast_result)

        if (intent.hasExtra(EXTRA_COUNT_KEY)) {
            setCount()
        }
    }

    private fun setCount() {
        val count = intent.getIntExtra(EXTRA_COUNT_KEY, DEFAULT_COUNT_VALUE)
        textViewCount.text = count.toString()
    }

    companion object {
        private const val EXTRA_COUNT_KEY = "count"
        private const val DEFAULT_COUNT_VALUE = 0

        fun newIntent(context: Context, count: Int) =
            Intent(context, HelloToastResultActivity::class.java).apply {
                putExtra(EXTRA_COUNT_KEY, count)
            }
    }
}