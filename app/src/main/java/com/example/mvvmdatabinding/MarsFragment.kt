package com.example.mvvmdatabinding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider


class MarsFragment : Fragment() {

    private lateinit var factory: MarsViewModelFactory
    private lateinit var viewModel: MarsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.mars_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val api = MarsApi()
        val repository = MarsRepository(api)
        factory = MarsViewModelFactory(repository)

        viewModel = ViewModelProvider(this, factory).get(MarsViewModel::class.java)
    }
}
