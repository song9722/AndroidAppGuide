package com.limlab.kotlinsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.layout_view_binding.*
import kotlin.math.pow

class BmiKotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_view_binding)

        bmiButton.setOnClickListener {
            // tallField의 값을 읽어온다.
            val tall = tallField.text.toString().toDouble()

            // weightField의 값을 읽어온다.
            val weight = weightField.text.toString().toDouble()

            // bmi를 계산한다.
            val bmi = weight / (tall / 100).pow(2)

            //bmi 결과를 resultLabel에 보여준다.
            resultLabel.text = "키 : $tall, 몸무게 : $weight, BMI : $bmi"

        }
    }
}
