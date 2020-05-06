package com.limlab.punchpower

import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    // 측정된 최대 펀치력
    var maxPower = 0.0
    // 펀치력 측정이 시작되었는지 나타내는 변수
    var isStart = false
    // 펀치력 측정이 시작된 시간
    var startTime = 0L

    // Sensor 관리자 객체. lazy 로 실제 사용될때 초기화 된다.
    val sensorManager: SensorManager by lazy {
        getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }

    // 센서 이벤트를 처리하는 리스너
    val eventListener: SensorEventListener = object : SensorEventListener {
        override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

        }

        override fun onSensorChanged(event: SensorEvent?) {
            event?.let{
                // 측정된 센서값이 선형 가속도 타입이 아니면 바로 리턴
                if(event.sensor.type != Sensor.TYPE_LINEAR_ACCELERATION) return@let
                // 각 좌표값을 제곱하여 음수값을 없애고, 값의 차이를 극대화
                val power = event.values[0].toDouble().pow(2.0) + event.values[1].toDouble().pow(2.0) + event.values[2].toDouble().pow(2.0)

                // 측정된 펀치력이 20 을 넘고 아직 측정이 시작되지 않은 경우
                if (power > 20 && !isStart) {
                    // 측정시작
                    startTime = System.currentTimeMillis()
                    isStart = true
                }

                // 측정이 시작된 경우
                if (isStart) {
                    // 5초간 최대값을 측정. 현재측정된 값이 지금까지 측정된 최대값보다 크면 최대값을 현재값으로 변경.
                    if(maxPower < power) maxPower = power

                    // 측정 중인것을 사용자에게 알려줌
                    stateLabel.text = getString(R.string.측정중)

                    // 최초 측정 후 3초가 지났으면 측정을 끝낸다
                    if (System.currentTimeMillis() - startTime > 3000) {
                        isStart = false
                        punchPowerTestComplete(maxPower)
                    }
                }
            }
        }
    }

    // 화면이 최초 생성될때 호출되는 함수
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // Activity 사라졌다 다시 보일때마다 호출되는 함수
    override fun onStart() {
        super.onStart()
        initGame()
    }

    // 게임을 초기화 한다
    private fun initGame() {
        maxPower = 0.0
        isStart = false
        startTime = 0L
        stateLabel.text = getString(R.string.측정전)

        // 센서의 변화값을 처리할 리스너를 등록한다
        // TYPE_LINEAR_ACCELERATION 은 중력값을 제외하고 x, y, z 축에 측정된 가속도만 계산되어 나온다.
        sensorManager.registerListener(
            eventListener,
            sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION),
            SensorManager.SENSOR_DELAY_NORMAL
        )
    }


    // 펀치력 측정이 완료된 경우 처리 함수
    private fun punchPowerTestComplete(power: Double) {
        Log.d("MainActivity","측정완료: power: ${String.format("%.5f", power)}")
        sensorManager.unregisterListener(eventListener)
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("Power", power)
        startActivity(intent)
    }

    // Activity 가 화면에서 사라지면 호출되는 함수
    override fun onStop() {
        super.onStop()
        try {
            sensorManager.unregisterListener(eventListener)
        } catch (e: Exception) {}
    }

}
