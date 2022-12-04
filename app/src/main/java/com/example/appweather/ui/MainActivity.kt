package com.example.appweather.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.appweather.databinding.ActivityMainBinding
import com.example.appweather.model.AllData

import com.example.appweather.service.ApiService
import com.example.appweather.service.RetrofitApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.search.setOnClickListener(View.OnClickListener {
            getWeather(binding.editCity.text.toString().trim())
            binding.tvCityName.text = binding.editCity.text.toString()

        })


    }

    fun getWeather(cityName: String){


        var apiInterface = RetrofitApi.getClient()?.create(ApiService::class.java)
        var call = apiInterface?.getWeather(cityName)
        call?.enqueue(object : Callback<AllData>{
            override fun onResponse(call: Call<AllData>, response: Response<AllData>) {
                binding.tvCityCode.text = response.body()?.id.toString()
                binding.tvHumidity.text = response?.body()?.main?.humidity.toString()
                binding.tvWindSpeed.text =response?.body()?.wind?.speed.toString()

            }

            override fun onFailure(call: Call<AllData>, t: Throwable) {
                Log.d("DATA", "problem")
            }
        })

    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}
