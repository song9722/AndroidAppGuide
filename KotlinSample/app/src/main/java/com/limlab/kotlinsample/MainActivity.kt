package com.limlab.kotlinsample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 레이아웃에 button이라는 ID로 선언된 뷰에 클릭 이벤트 리스너를 등록한다.
        button1.setOnClickListener {
            //Intent로 BmiJavaActivity 를 타겟으로 하고 startActivity 로 실행
            startActivity(Intent(this@MainActivity, BmiJavaActivity::class.java ))
        }

        button2.setOnClickListener {
            startActivity(Intent(this@MainActivity, BmiKotlinActivity::class.java))
        }
    }
}
