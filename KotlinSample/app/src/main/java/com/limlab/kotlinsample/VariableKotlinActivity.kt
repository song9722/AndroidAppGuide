package com.limlab.kotlinsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.layout_variable.*
import java.text.SimpleDateFormat
import java.util.*

class VariableKotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        //클릭된 횟수를 저장할 변수
        var clickCount = 0
        //Activity 가 시작된 시간
        val startTime = System.currentTimeMillis()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_variable)

        //시작시간을 text형태로 변환
        val timeText = SimpleDateFormat("HH:mm:ss", Locale.KOREA).format(startTime)

        //시작시간을 TextView 에 보여줌
        startTimeLabel.text = "시작시간 : $timeText"

        //클릭된 횟수를 보여줌
        clickCountLabel.text = "클릭한 횟수 : $clickCount"

        //버튼에 이벤트리스너 설정
        button.setOnClickListener {
            clickCount++
            clickCountLabel.text = "클릭한 횟수 : $clickCount"

        }


    }
}
