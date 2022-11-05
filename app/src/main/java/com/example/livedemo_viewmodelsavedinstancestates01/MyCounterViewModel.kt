package com.example.livedemo_viewmodelsavedinstancestates01

import android.util.Log
import androidx.lifecycle.ViewModel

private const val LOG_TAG = "MyCounterViewModel"

class MyCounterViewModel : ViewModel() {

    private var currentCount: Int = 0

    override fun onCleared() {
        Log.v(LOG_TAG, "MyCounterViewModel::onCleared()")
        super.onCleared()
    }

    fun increaseCount() {
        this.adjustCount(1)
    }

    fun adjustCount(adjustment: Int) {
        this.currentCount += adjustment
    }

    fun getCount(): Int {
        return this.currentCount
    }

    fun setCount(c: Int) {
        this.currentCount = c
    }
}