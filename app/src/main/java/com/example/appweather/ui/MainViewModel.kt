package com.example.appweather.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appweather.model.All
import com.example.appweather.model.AllList
import com.example.appweather.service.RetrofitApi
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel: ViewModel(){

    private val searchControl = MutableLiveData<Boolean>()
    val weather_data = MutableLiveData<List<All>>()

    fun refreshData(cityName: String) {
        getDataFromAPI(cityName)
    }


   fun search(cityName : String) {
        if (!cityName.isEmpty()) {
            searchControl.postValue(false);
           getDataFromAPI(cityName);
        } else
            searchControl.postValue(true);
    }



  private fun getDataFromAPI(cityName: String) {
      RetrofitApi.getDataService(cityName).enqueue(object: Callback<AllList>{
          override fun onResponse(call: Call<AllList>, response: Response<AllList>) {

              if(response.body() != null){

                  weather_data.postValue(response.body()!!.data)

              }
              else{
                  return
              }
          }

          override fun onFailure(call: Call<AllList>, t: Throwable) {
              Log.d("DOES NOT WORK", t.message.toString())
          }

      })
  }

    fun observeDetail(): LiveData<List<All>> {
        return weather_data
    }

    fun getSearchControl(): LiveData<Boolean?> {
        return searchControl
    }


}