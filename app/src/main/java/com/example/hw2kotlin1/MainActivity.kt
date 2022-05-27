package com.example.hw2kotlin1

import android.os.Bundle
import android.webkit.URLUtil.*
import androidx.appcompat.app.AppCompatActivity
import com.example.hw2kotlin1.databinding.ActivityMainBinding
import com.example.hw2kotlin1.extentions.loadGlide
import com.example.hw2kotlin1.extentions.randomList
import com.example.hw2kotlin1.extentions.showToast14

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val imageArray = listOf(
        R.drawable.ic_1_dog,
        R.drawable.ic_2,
        R.drawable.ic_3,
        R.drawable.ic_4,
        R.drawable.ic_5,
        R.drawable.ic_6,
        R.drawable.ic_7,
        R.drawable.ic_9,
        R.drawable.ic_10,
        R.drawable.ic_99
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnClickMethod()
    }

    private fun setOnClickMethod() {
        binding.apply {
            submitButton.setOnClickListener {
                if (isHttpsUrl(editText1.text.toString()) || isHttpUrl(editText1.text.toString()) && isValidUrl(editText1.text.toString()))
                    imageView.loadGlide(editText1.text.toString())
                else showToast14("Пожалуйста, правильно укажите ссылку")
            }

            //Реализация рандома
            randomButton.setOnClickListener {
                imageView.setImageResource(imageArray.randomList())
            }
        }
    }
}
