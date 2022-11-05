package com.example.livedemo_viewmodelsavedinstancestates01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders

private const val LOG_TAG = "MainActivity"
private const val COUNTER_KEY = "counter"

class MainActivity : AppCompatActivity() {

    private lateinit var countLabel: TextView
    private lateinit var increaseButton: Button

    private val counterViewModel: MyCounterViewModel by lazy {
        ViewModelProviders.of(this).get(MyCounterViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.connectViews()
        this.setupCallbacks()

        this.counterViewModel.setCount(
            savedInstanceState?.getInt(COUNTER_KEY, 0) ?: 0
        )

        this.updateCountLabel()
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {

        Log.v(LOG_TAG, "onSaveInstanceState() - begin")
        super.onSaveInstanceState(savedInstanceState)
        savedInstanceState.putInt(COUNTER_KEY, this.counterViewModel.getCount())
    }

    private fun connectViews() {
        this.countLabel = this.findViewById(R.id.current_count_label)
        this.increaseButton = this.findViewById(R.id.increase_count_button)
    }

    private fun setupCallbacks() {
        this.increaseButton.setOnClickListener {
            println("Increase button was clicked!")

            this.counterViewModel.increaseCount()
            this.updateCountLabel()
        }
    }

    private fun updateCountLabel() {
        this.countLabel.text = this.counterViewModel.getCount().toString()
    }
}