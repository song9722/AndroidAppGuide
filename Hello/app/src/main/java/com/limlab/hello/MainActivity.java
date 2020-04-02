package com.limlab.hello;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // 버튼이 클린된 횟수를 저장하는 변수를 선언한다.
    int clickCount = 0;

    /**
     * Main Activity 가 최초 실행될 때 실행된다.
     * 자바독 주석을 확인하려면 F1키를 누르자.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         // Activity의 UI를 R.layout.activity_main 으로 지정한다.
        setContentView(R.layout.activity_main);

         // "프로그래밍을 시작해보자" 메세지를 잠시 보여준다.
        Toast.makeText(getApplicationContext(),"프로그래밍을 시작해보자",Toast.LENGTH_LONG).show();

        // 레이아웃에 button 이라는 ID 로 선언된 뷰에 클린 이벤트 리스너를 등록한다.
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //클릭카운트를 1회씩 증가시킨다.
                clickCount++;

               // 화면에 보여줄 메세지를 저장할 변수를 선언한다.
                String text = "";

                for (int i = 0; i < clickCount; i++) {
                    if (i > 3) {
                        break;
                    }
                    text += "안녕.";
                }
                Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT).show();

            }
        });
    }
}
