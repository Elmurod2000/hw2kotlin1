package com.example.hw2kotlin1.extentions

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadGlide(url: String) {
    Glide.with(this).load(url).centerCrop().into(this)
}