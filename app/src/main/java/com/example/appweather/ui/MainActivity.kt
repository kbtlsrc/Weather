package com.example.appweather.ui

import android.content.ContentValues.TAG
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appweather.databinding.ActivityMainBinding
import com.example.appweather.model.All


class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    lateinit var mainAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        initComponents()

        binding.search.setOnClickListener { v ->
            viewModel.search(binding.editCity.text.toString())

        }
        getLive()




    }

    private fun initComponents() {
        //Recycler View initialize
        mainAdapter = MainAdapter()
        binding.rvWeather.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

            adapter = mainAdapter
        }
    }

    fun getLive() {
        viewModel.observeDetail().observe(this, Observer { data ->
            if (data != null) {
                mainAdapter.setAdapterList(data as ArrayList<All>)
            }
        })
        viewModel.getSearchControl().observe(this, Observer { bool ->
            if (bool == true) {
                Toast.makeText(this, "You should enter at least one letter", Toast.LENGTH_SHORT)
                    .show()
            }


        })


    }


}
