package com.bignerdranch.android.uas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.bignerdranch.android.uas.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var trueButton: Button
    private lateinit var falseButton: Button

    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true))

    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)

        trueButton.setOnClickListener {
            binding.trueButton.setOnClickListener {
                // Do something in response to the click here
                Toast.makeText(
                    this,
                    R.string.correct_toast,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        falseButton.setOnClickListener {
            binding.falseButton.setOnClickListener {
                // Do something in response to the click here
                Toast.makeText(
                    this,
                    R.string.incorrect_toast,
                    Toast.LENGTH_SHORT
                ).show()
            }

            binding.nextButton.setOnClickListener {
                currentIndex = (currentIndex + 1) % questionBank.size
                val questionTextResId = questionBank[currentIndex].textResId
                binding.questionTextView.setText(questionTextResId)
                updateQuestion()
            }

            val questionTextResId = questionBank[currentIndex].textResId
            binding.questionTextView.setText(questionTextResId)
            updateQuestion()
        }

    }
    private fun updateQuestion() {
        val questionTextResId = questionBank[currentIndex].textResId
        binding.questionTextView.setText(questionTextResId)
    }
}