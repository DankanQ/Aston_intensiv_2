package com.dankanq.aston_intensiv_2

import android.view.View
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity

object Utils {
    fun <T : Any?> AppCompatActivity.bind(@IdRes idRes: Int): Lazy<T> {
        return lazy(LazyThreadSafetyMode.NONE) {
            findViewById<View>(idRes) as T
        }
    }
}