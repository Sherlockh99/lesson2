package com.sherlock.gb.kotlin.lesson2.view.details

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.sherlock.gb.kotlin.lesson2.R
import com.sherlock.gb.kotlin.lesson2.viewmodel.AppState
import com.sherlock.gb.kotlin.lesson2.databinding.FragmentMainBinding
import com.sherlock.gb.kotlin.lesson2.model.Weather
import com.sherlock.gb.kotlin.lesson2.viewmodel.MainViewModel

class DetailsFragment : Fragment() {
/**
    companion object {
        @JvmStatic
        fun newInstance() = DetailsFragment()
        //fun newInstance(param1: String, param2: String) = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    private var _binding: FragmentMainBinding?=null
    private val binding get()=_binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        //return inflater.inflate(R.layout.fragment_main, container, false)
        return binding.root
    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        /**
        /**
         * Мы создали инстанс Observer, он выполняет метод renderData,
         * как только LiveData обновляет данные, которые она хранит.
         * В качестве аргумента renderData принимает объект, возвращаемый лайвдатой.
         */
        val observer = Observer<Any> {renderData(it)}
        /**
         * Далее вызываем у созданной ViewModel метод getData, возвращающий нам LiveData,
         * и вызываем у LiveData метод observe, который и передаём в жизненный цикл вместе с Observer
         */
        viewModel.getData().observe(viewLifecycleOwner, observer)
        /**
         * Теперь, если данные, которые хранит LiveData, изменятся,
         * Observer сразу об этом узнает и вызовет метод renderData, куда передаст новые данные.
         */
        */
        /**
         * подписываемся на LiveData и запрашиваем данные.
         */
        viewModel.getLiveData().observe(viewLifecycleOwner, Observer{renderData(it)})
        //viewModel.getWeather()
    }



    private fun renderData(appState: AppState) {
        /**
         * принимаем объект состояния приложения
         * и через when определяем, что потребуется отображать
         */
        val loadingLayout = binding.loadingLayout
        val mainView = binding.mainView
        when(appState){
            is AppState.Success->{
                val weatherData = appState.weatherData
                loadingLayout.visibility = View.GONE
                setData(weatherData)
                //Snackbar.make(mainView,"Sucess", Snackbar.LENGTH_LONG).show()
            }
            is AppState.Loading -> {
                loadingLayout.visibility = View.VISIBLE
            }
            is AppState.Error->{
                loadingLayout.visibility = View.GONE
                Snackbar
                    .make(mainView,"Error", Snackbar.LENGTH_INDEFINITE)
                    .setAction("Reload"){viewModel.getWeather()}
                    .show()
            }
        }


        //Toast.makeText(context, "data", Toast.LENGTH_LONG).show()

    }

    private fun setData(weatherData: Weather){
        binding.cityName.text = weatherData.city.city
        binding.cityCoordinates.text = String.format(
            getString(R.string.city_coordinates),
            weatherData.city.lat.toString(),
            weatherData.city.lon.toString()
        )
        binding.temperatureValue.text = weatherData.temperature.toString()
        binding.feelsLikeValue.text = weatherData.feelsLike.toString()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    */
}