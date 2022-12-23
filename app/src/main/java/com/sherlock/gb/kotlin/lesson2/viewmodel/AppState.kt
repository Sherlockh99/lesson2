package com.sherlock.gb.kotlin.lesson2.viewmodel

import com.sherlock.gb.kotlin.lesson2.model.Weather

sealed class AppState {
    data class Success(val weatherData: Weather) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}