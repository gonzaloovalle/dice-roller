package com.example.dice_roller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
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

        //Do a dice roll when app starts
        rollDice()
    }
    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        //Create lucky number and conditional logic for when lucky number is rolled
        val luckyNumber = 4
        val resultTextView2: TextView = findViewById(R.id.textView2)
        when (diceRoll) {
            luckyNumber -> resultTextView2.text = ("You win!")
            1 -> resultTextView2.text = ("Sorry, roll again")
            2 -> resultTextView2.text = ("You lost, roll again")
            3 -> resultTextView2.text = ("Close, but no, roll again")
            5 -> resultTextView2.text = ("Maybe next time, roll again")
            6 -> resultTextView2.text = ("Better luck next time, roll again")
        }


        // Update the screen with the dice roll
        val diceImage: ImageView = findViewById(R.id.imageView)
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()

    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}