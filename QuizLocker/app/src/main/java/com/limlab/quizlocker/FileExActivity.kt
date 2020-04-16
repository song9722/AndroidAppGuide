package com.limlab.quizlocker

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_file_ex.*
import java.io.FileNotFoundException

class FileExActivity : AppCompatActivity() {

    val fileName = "data.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file_ex)

        saveButton.setOnClickListener {
            val text = textField.text.toString()
            when {
                TextUtils.isEmpty(text) -> {
                    Toast.makeText(applicationContext, "텍스트가 비었습니다.", Toast.LENGTH_LONG).show()
                }
                else -> {
                    saveToInnerStorage(text, fileName)
                }
            }
        }

        loadButton.setOnClickListener {
            try {
                textField.setText(loadFromInnerStorage(fileName))
            } catch (e: FileNotFoundException) {
                Toast.makeText(applicationContext, "저장된 텍스트가 없습니다.", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun saveToInnerStorage(text: String, fileName: String) {
        val fileOutputStream = openFileOutput(fileName, Context.MODE_PRIVATE)

        fileOutputStream.write(text.toByteArray())

        fileOutputStream.close()
    }

    fun loadFromInnerStorage(fileName: String): String {
        val fileInputStream = openFileInput(fileName)

        return fileInputStream.reader().readText()
    }
}
