package com.limlab.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        randomCard.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putIntegerArrayListExtra("result", ArrayList(getRandomLottoNumbers()))
            startActivity(intent)
        }

        constellationCard.setOnClickListener {
            startActivity(Intent(this, ConstellationActivity::class.java))
        }

        nameCard.setOnClickListener {
            startActivity(Intent(this, NameActivity::class.java))
        }
    }

    private fun getRandomLottoNumber(): Int {
        return Random().nextInt(45) + 1
    }

    private fun getRandomLottoNumbers(): MutableList<Int> {
        val lottoNumbers = mutableListOf<Int>()

        for (i in 1..6) {
            var num = 0
            do {
                num = getRandomLottoNumber()
            } while (lottoNumbers.contains(num))

            lottoNumbers.add(num)
        }
        return lottoNumbers
    }

    fun getShuffleLottoNumbers(): MutableList<Int> {
        val list = mutableListOf<Int>()

        for (num in 1..45) {
            list.add(num)
        }

        list.shuffle()

        return list.subList(0, 6)
    }
}
