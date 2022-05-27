package com.example.hw2kotlin1.extentions

import android.content.Context
import android.widget.Toast

fun Context.showToast14(message: String){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}