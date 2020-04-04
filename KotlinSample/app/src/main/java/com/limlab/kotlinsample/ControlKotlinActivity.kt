package com.limlab.kotlinsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.layout_control.*

class ControlKotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_control)

        //버튼이 클릭되었을때 이벤트 리스너를 설정한다
        button.setOnClickListener {
            val number = numberField.text.toString().toInt()

            when {
                number % 2 == 0 -> toastShort("${number}는 2의 배수입니다.")
                number % 3 == 0 -> toastShort("${number}는 3의 배수입니다.")
                else -> toastShort("$number")

            }

            when (number) {
                in 1..4 -> button.text = "실행 - 4"
                9, 18 -> button.text = "실행 - 9"
                else -> button.text = "실행"
            }
        }
    }
}
