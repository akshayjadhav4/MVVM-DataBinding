package com.example.mvvmdatabinding.ui.mars

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmdatabinding.R
import com.example.mvvmdatabinding.data.models.MarsProperty
import com.example.mvvmdatabinding.databinding.RecyclerviewMarsBinding

class MarsAdapter(
    private val marsProperties: List<MarsProperty>
) : RecyclerView.Adapter<MarsAdapter.MarsViewHolder>() {

    override fun getItemCount() = marsProperties.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MarsViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.recyclerview_mars,
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: MarsViewHolder, position: Int) {
        holder.recyclerviewMarsBinding.mars = marsProperties[position]

        //clickListener
        //This approach is for all card
        holder.recyclerviewMarsBinding.root.setOnClickListener { }

        //For specific element
        holder.recyclerviewMarsBinding.marsType.setOnClickListener {}
    }

    inner class MarsViewHolder(val recyclerviewMarsBinding: RecyclerviewMarsBinding) :
        RecyclerView.ViewHolder(recyclerviewMarsBinding.root)
}