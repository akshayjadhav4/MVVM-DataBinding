package com.example.mvvmdatabinding.ui.mars

import android.view.View
import com.example.mvvmdatabinding.data.models.MarsProperty

interface RecyclerViewCLickListener {
    fun onTypeClicked(view:View,mars:MarsProperty)
}