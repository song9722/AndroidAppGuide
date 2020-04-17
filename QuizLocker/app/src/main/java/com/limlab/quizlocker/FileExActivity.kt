package com.limlab.quizlocker

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_file_ex.*
import java.io.File
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream

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
                !isExternalStorageWritable() -> {
                    Toast.makeText(applicationContext, "외부 저장장치가 없습니다.", Toast.LENGTH_LONG).show()
                }

                else -> {
                    // saveToInnerStorage(text, fileName)
                    saveToExternalStorage(text, fileName)
                }
            }
        }

        loadButton.setOnClickListener {
            try {
                //textField.setText(loadFromInnerStorage(fileName))
                textField.setText(loadFromExternalStorage(fileName))
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

    fun isExternalStorageWritable(): Boolean {
        when {
            Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED -> return true
            else -> return false
        }
    }

    fun getAppDataFileFromExternalStorage(fileName: String): File {
        val dir = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)
        } else {
            File(Environment.getExternalStorageDirectory().absolutePath + "/Documents")
        }

        dir?.mkdir()
        return File("${dir?.absolutePath}${File.separator}${fileName}")
    }

    fun saveToExternalStorage(text: String, fileName: String) {
        val fileOutputStream = FileOutputStream(getAppDataFileFromExternalStorage(fileName))
        fileOutputStream.write(text.toByteArray())
        fileOutputStream.close()
    }

    fun loadFromExternalStorage(fileName: String): String {
        return FileInputStream(getAppDataFileFromExternalStorage(fileName)).reader().readText()
    }
}
