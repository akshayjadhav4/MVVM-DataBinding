package com.example.mvvmdatabinding.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmdatabinding.data.repository.MarsRepository

@Suppress("UNCHECKED_CAST")
class MarsViewModelFactory(private val repository: MarsRepository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MarsViewModel(repository) as T
    }
}