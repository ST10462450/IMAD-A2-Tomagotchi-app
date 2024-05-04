package com.example.tomagatchi_assignment2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class GameActivity : AppCompatActivity() {
    private lateinit var PlayButton: Button
    private lateinit var FeedButton: Button
    private lateinit var CleanButton: Button
    private lateinit var joyTextView: TextView
    private lateinit var hungerTextView: TextView
    private lateinit var cleanTextView: TextView
    private lateinit var monkeyPet: MonkeyPet
    private lateinit var monkeyImageView: ImageView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_game)


        monkeyPet = MonkeyPet()
        PlayButton = findViewById(R.id.PlayButton)
        FeedButton = findViewById(R.id.FeedButton)
        CleanButton = findViewById(R.id.CleanButton)
        joyTextView = findViewById(R.id.joyTextView)
        hungerTextView = findViewById(R.id.hungerTextView)
        cleanTextView = findViewById(R.id.cleanTextView)
        monkeyImageView = findViewById(R.id.monkeyImageView)

        updateStatus()

        FeedButton.setOnClickListener { monkeyPet.feed(); updateStatus(); monkeyImageView.setImageResource(R.drawable.hungry_monkey) }
        PlayButton.setOnClickListener { monkeyPet.play(); updateStatus(); monkeyImageView.setImageResource(R.drawable.playin_monkey) }
        CleanButton.setOnClickListener { monkeyPet.clean(); updateStatus(); monkeyImageView.setImageResource(R.drawable.bathing_monkey) }

        Timer()
    }

    private fun updateStatus() {
        with(monkeyPet) {
            joyTextView.text = "Joy: $joy"
            hungerTextView.text = "Hunger: $hunger"
            cleanTextView.text = "Cleanliness: $cleanliness"
        }
    }

    private fun Timer() {
        GlobalScope.launch {
            while (true) {
                with(monkeyPet) {
                    decreaseCleanliness()
                    decreaseHealth()
                    decreaseJoy()
                    increaseHunger()
                    updateStatus()
                }
                delay(25000)
            }
        }
    }
}





