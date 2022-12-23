package com.sherlock.gb.kotlin.lesson2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sherlock.gb.kotlin.lesson2.viewmodel.AppState
import java.lang.Thread.sleep

class MainViewModel(
    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData()) : ViewModel() {

    fun getLiveData() = liveDataToObserve
    fun getWeather() = getDataFromLocalSource()

    fun getData(): LiveData<AppState> {
        /**
         * Добавим метод getDataFromLocalSource, который имитирует запрос к БД
         * или ещё какому-то источнику данных в приложении.
         */
        getDataFromLocalSource()
        return liveDataToObserve
    }

    private fun getDataFromLocalSource() {
        //liveDataToObserve.value = AppState.Loading
        /**
         * Запрос осуществляется асинхронно в отдельном потоке. Как только
         * поток «просыпается», передаём в нашу LiveData какие-то данные через метод postValue.
         * Если данные передаются в основном потоке, используем метод setValue.
         */
        Thread {
            sleep(2000)
            liveDataToObserve.postValue(AppState.Success(Any()))
        }.start()
    }
}
