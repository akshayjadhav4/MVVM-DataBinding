package com.example.mvvmdatabinding.ui.mars

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmdatabinding.R
import com.example.mvvmdatabinding.data.models.MarsProperty
import com.example.mvvmdatabinding.data.network.MarsApi
import com.example.mvvmdatabinding.data.repository.MarsRepository
import kotlinx.android.synthetic.main.mars_fragment.*


class MarsFragment : Fragment(), RecyclerViewCLickListener {

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
        viewModel.getMarsProperties()
        viewModel.marsProperties.observe(viewLifecycleOwner, Observer { properties ->
            recycler_view_mars.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter =
                    MarsAdapter(properties, this)
            }
        })
    }

    override fun onTypeClicked(view: View, mars: MarsProperty) {
        when (view.id) {
            R.id.mars_type -> {
                Toast.makeText(requireContext(), "${mars.type}", Toast.LENGTH_SHORT).show()
            }
            R.id.recycler_view_mars -> {
                Toast.makeText(requireContext(), "${mars.id}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
