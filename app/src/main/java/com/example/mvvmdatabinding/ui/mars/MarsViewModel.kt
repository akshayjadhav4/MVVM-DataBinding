package com.example.mvvmdatabinding.ui.mars

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmdatabinding.util.Coroutines
import com.example.mvvmdatabinding.data.models.MarsProperty
import com.example.mvvmdatabinding.data.repository.MarsRepository
import kotlinx.coroutines.Job

class MarsViewModel(private val repository: MarsRepository) : ViewModel() {

    private lateinit var job: Job

    //Live data
    private val _marsProperties = MutableLiveData<List<MarsProperty>>()
    val marsProperties: LiveData<List<MarsProperty>>
        get() = _marsProperties

    fun getMarsProperties() {
        job = Coroutines.ioThenMain(
            { repository.getMarsProperties() },
            { _marsProperties.value = it }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }
}
