package com.limlab.hello;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    // testButton1 의 클릭횟수를 저장하는 변수를 선언한다.
    int clickCount1 = 0;

    // testButton2 의 클릭횟수를 저장하는 변수를 선언한다.
    int clickCount2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // 프로그래밍을 시작해보자 메세지를 잠시 보여준다.
        Toast.makeText(getApplicationContext(), "프로그램을 시작해보자!", Toast.LENGTH_SHORT).show();

        // 레이아웃에 testButton1 ID로 선언된 뷰에 클릭 이벤트 리스너를 등록한다.
        findViewById(R.id.testButton1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 클릭카운트를 1회 증가시킨다.
                clickCount1++;

                showMessage(clickCount1);

            }
        });

        // 레이아웃에 testButton2 ID로 선언된 뷰에 클릭 이벤트 리스너를 등록한다.
        findViewById(R.id.testButton2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 클릭카운트를 1회 증가시킨다.
                clickCount2++;

                showMessage(clickCount2);

            }
        });
    }

    // 함수에 전달받은 클릭횟수로 조건에 따라 메세지를 보여준다.
    void showMessage(int clickCount) {
        if (clickCount % 2 == 0) {
            Toast.makeText(getApplicationContext(), "클릭횟수 : " + clickCount, Toast.LENGTH_SHORT).show();
        } else if (clickCount % 3 == 0) {
            Toast.makeText(getApplicationContext(), "Hello, World!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Hello~", Toast.LENGTH_SHORT).show();
        }
    }
}
