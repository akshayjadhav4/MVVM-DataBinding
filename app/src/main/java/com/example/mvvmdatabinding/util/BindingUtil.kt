package com.example.mvvmdatabinding.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

//image value passing in pram is used in xml
@BindingAdapter("image")
fun loadImage(view: ImageView, url: String) {
    Glide.with(view).load(url).into(view)
}