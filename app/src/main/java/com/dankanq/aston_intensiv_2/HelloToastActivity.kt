package com.dankanq.aston_intensiv_2

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.dankanq.aston_intensiv_2.Utils.bind

class HelloToastActivity : AppCompatActivity() {
    private val buttonToast by bind<Button>(R.id.button_toast)
    private val buttonZero by bind<Button>(R.id.button_zero)
    private val buttonCount by bind<Button>(R.id.button_count)
    private val textViewCount by bind<TextView>(R.id.text_view_count)
    private val buttonPicture by bind<Button>(R.id.button_picture)

    private var count = ZERO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello_toast)

        if (savedInstanceState != null) {
            count = savedInstanceState.getInt(EXTRA_COUNT_KEY)

            if (count != 0) {
                buttonZero.setBackgroundColorRes(R.color.pink)
                buttonCount.setBackgroundColorRes(R.color.green)
            }

            val textViewColorId = if (count % 2 == 0) R.color.yellow else R.color.gray
            updateTextView(textViewColorId)
        }

        setOnClickListeners()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt(EXTRA_COUNT_KEY, count)
    }

    private fun setOnClickListeners() {
        buttonToast.setOnClickListener { launchHelloToastResultActivity() }
        buttonZero.setOnClickListener { dropCount() }
        buttonCount.setOnClickListener { countUp() }
        buttonPicture.setOnClickListener { openCamera() }
    }

    private fun launchHelloToastResultActivity() {
        val intent = HelloToastResultActivity.newIntent(this, count)
        startActivity(intent)
    }

    private fun dropCount() {
        count = ZERO

        buttonZero.setBackgroundColorRes(R.color.gray)
        buttonCount.setBackgroundColorRes(R.color.purple_200)

        updateTextView(R.color.yellow)
    }

    private fun countUp() {
        count++

        buttonZero.setBackgroundColorRes(R.color.pink)
        buttonCount.setBackgroundColorRes(R.color.green)

        val textViewColorId = if (count % 2 == 0) R.color.yellow else R.color.gray
        updateTextView(textViewColorId)
    }

    private fun openCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivity(intent)
    }

    private fun View.setBackgroundColorRes(@ColorRes colorRes: Int) {
        setBackgroundColor(ContextCompat.getColor(this@HelloToastActivity, colorRes))
    }

    private fun updateTextView(@ColorRes colorRes: Int) {
        with(textViewCount) {
            setBackgroundColorRes(colorRes)
            text = count.toString()
        }
    }

    companion object {
        private const val EXTRA_COUNT_KEY = "count"

        private const val ZERO = 0
    }
}