package com.limlab.quizlocker

import android.Manifest.permission.WRITE_EXTERNAL_STORAGE
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.text.TextUtils
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_file_ex.*
import java.io.File
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.util.jar.Manifest

class FileExActivity : AppCompatActivity() {

    var granted = false

    val fileName = "data.txt"

    val MY_PERMISSION_REQUEST = 999

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file_ex)

        checkPermission()

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
                    //saveToExternalStorage(text, fileName)
                    saveToExternalCustomDirectory(text)
                }
            }
        }

        loadButton.setOnClickListener {
            try {
                //textField.setText(loadFromInnerStorage(fileName))
                //textField.setText(loadFromExternalStorage(fileName))
                textField.setText(loadFromExternalCustomDirectory())
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

    fun checkPermission() {
        val permissionCheck = ContextCompat.checkSelfPermission(this, WRITE_EXTERNAL_STORAGE)

        when {
            permissionCheck != PackageManager.PERMISSION_GRANTED -> {
                ActivityCompat.requestPermissions(
                    this, arrayOf(WRITE_EXTERNAL_STORAGE), MY_PERMISSION_REQUEST
                )
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            MY_PERMISSION_REQUEST -> {
                granted = when {
                    grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED -> {
                        true
                    }
                    else -> false
                }
            }
        }
    }

    fun saveToExternalCustomDirectory(text: String, filePath: String = "/sdcard/data.txt") {
        when {
            granted -> {
                val fileOutputStream = FileOutputStream(File(filePath))
                fileOutputStream.write(text.toByteArray())
                fileOutputStream.close()
            }

            else -> {
                Toast.makeText(applicationContext, "권한이 없습니다.", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun loadFromExternalCustomDirectory(filePath: String = "/sdcard/data.txt"): String {
        when {
            granted -> {
                return FileInputStream(File(filePath)).reader().readText()
            }
            else -> {
                Toast.makeText(applicationContext, "권한이 없습니다", Toast.LENGTH_LONG).show()
                return ""
            }
        }
    }
}
