package allgift.technologies.biggernumber

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLeft = findViewById<Button>(R.id.btnLeft)
        val btnRight = findViewById<Button>(R.id.btnRight)

        assignNumbersToButtons()

        btnLeft.setOnClickListener {
            //code here will run everytime the left button is clicked!
            // Compare the numbers in the boxes
            checkAnswer(true)
            // Assign new random numbers
            assignNumbersToButtons()
        }

        btnRight.setOnClickListener {
            //code here will run everytime the left button is clicked!
            // Compare the numbers in the boxes
            checkAnswer(false)
            // Assign new random numbers
            assignNumbersToButtons()
        }
    }

    private fun checkAnswer(isLeftButtonSelected: Boolean){
        val btnLeft = findViewById<Button>(R.id.btnLeft)
        val btnRight = findViewById<Button>(R.id.btnRight)

        val leftNum:Int = btnLeft.text.toString().toInt()
        val rightNum:Int = btnRight.text.toString().toInt()
        val backgroundView = findViewById<ConstraintLayout>(R.id.backgroundView)
        var isAnswerCorrect = if (isLeftButtonSelected) leftNum > rightNum else rightNum > leftNum

        if(isAnswerCorrect) {
            // Correct answer!!
            // Change background color
            backgroundView.setBackgroundColor(Color.GREEN)
            // Toast
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
        }
        else {
            // Wrong answer!!
            // Change background color
            backgroundView.setBackgroundColor(Color.RED)
            // Toast
            Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show()
        }
    }

    private fun assignNumbersToButtons() {
        val btnLeft = findViewById<Button>(R.id.btnLeft)
        val btnRight = findViewById<Button>(R.id.btnRight)

        val r = Random()
        val leftNum = r.nextInt(10)
        var rightNum = leftNum
        while (rightNum == leftNum) {
            rightNum = r.nextInt(10)
        }
        btnLeft.text = leftNum.toString()
        btnRight.text = rightNum.toString()
    }
}