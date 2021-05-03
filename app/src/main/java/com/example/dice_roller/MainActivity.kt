package com.example.dice_roller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
    }
    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        //Create lucky number and conditional for when lucky number is rolled
        val luckyNumber = 4
        val resultTextView2: TextView = findViewById(R.id.textView2)
        if (diceRoll == luckyNumber) {
            resultTextView2.text = ("You win!")
        } else if (diceRoll == 1) {
            resultTextView2.text = ("Sorry, roll again")
        } else if (diceRoll == 2) {
            resultTextView2.text = ("You lost, roll again")
        } else if (diceRoll == 3) {
            resultTextView2.text = ("Close, but no, roll again")
        } else if (diceRoll == 5) {
            resultTextView2.text = ("Maybe next time, roll again")
        } else {
            resultTextView2.text = ("Better luck next time, roll again")
        }

        // Update the screen with the dice roll
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}