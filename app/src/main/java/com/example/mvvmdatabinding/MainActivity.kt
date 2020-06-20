package com.example.mvvmdatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = MarsRepository(MarsApi())
        GlobalScope.launch(Dispatchers.Main) {
            val properties = repository.getMarsProperties()
            Toast.makeText(this@MainActivity, properties.toString(), Toast.LENGTH_LONG).show()
        }
    }
}
