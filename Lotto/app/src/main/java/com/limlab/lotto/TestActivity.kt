package com.limlab.lotto

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_test.*

class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        //코드에서 뷰에 이벤트 리스너를 설정하는 방법
        //코틀린에서는 findViewId 없이 바로 접근 가능하다
        //버튼과 같은 뷰가 클릭되었을때 실행될 리스너를 등록하는 메소드가 setOnClickListener 이다
        button.setOnClickListener {
            //Main Activity를 시작하는 Intent를 생성한다
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        button2.setOnClickListener {
            startActivity(Intent(this, ConstellationActivity::class.java))
        }

        button3.setOnClickListener {
            startActivity(Intent(this, NameActivity::class.java))
        }

        button4.setOnClickListener {
            startActivity(Intent(this, ResultActivity::class.java))
        }


    }

    /**
     * xml에서 참조할 수 있게 메소드를 정의한다
     */
    fun goConstellation(view: View) {
        //ConstellationActivity 로 전환하는 코드
        val intent = Intent(this, ConstellationActivity::class.java)
        startActivity(intent)
    }
    fun callweb(view: View) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.daum.net"))
        startActivity(intent)
    }
}
