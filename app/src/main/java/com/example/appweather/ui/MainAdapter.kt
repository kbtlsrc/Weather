package com.example.appweather.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appweather.databinding.ItemWeatherBinding
import com.example.appweather.model.All

class MainAdapter: RecyclerView.Adapter<MainAdapter.MainViewHolders>() {
    private var weather= ArrayList<All>()

    class MainViewHolders(val binding: ItemWeatherBinding): RecyclerView.ViewHolder(binding.root)

    fun setAdapterList(weather: List<All>){
        this.weather = weather as ArrayList<All>
        this.weather.clear()
        this.weather.addAll(weather)
        notifyDataSetChanged()


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolders {
       return MainViewHolders(ItemWeatherBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MainViewHolders, position: Int) {
        Glide.with(holder.itemView)
            .load("https://openweathermap.org/img/wn/" + (weather[position].icon) + "@2x.png")
            .into(holder.binding.imgWeatherPictures)

        holder.binding.tvCityCode.text = weather[position].country
       /* holder.binding.tvCityName.text = weather[position].name
        holder.binding.tvDegree.text = weather[position].temp.toString() + "°C"
        holder.binding.tvHumidity.text = weather[position].humidity.toString() + "%"
        holder.binding.tvWindSpeed.text = weather[position].speedWind.toString()
        holder.binding.tvLat.text = weather[position].lat.toString()
        holder.binding.tvLon.text = weather[position].lon.toString()
*/



    }

    override fun getItemCount(): Int {
        return weather.size
    }

}