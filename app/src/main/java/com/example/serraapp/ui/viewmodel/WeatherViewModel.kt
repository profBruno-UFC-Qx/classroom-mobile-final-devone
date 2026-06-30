package com.example.serraapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.serraapp.repository.WeatherRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val repository: WeatherRepository
): ViewModel(){
    private val _temp = MutableStateFlow<Double?>(null)
    val temp = _temp.asStateFlow()

    private val _desc = MutableStateFlow("")
    val desc = _desc.asStateFlow()

    fun loadWeather(city: String){
        viewModelScope.launch {
            try {
                val result = repository.getWeather(city)

                _temp.value = result.main.temp
                _desc.value = result.weather.firstOrNull()?.description ?: ""
            } catch (e: Exception){
                println("erro clima: ${e.message}")
            }
        }
    }
}