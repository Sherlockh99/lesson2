package com.sherlock.gb.kotlin.lesson2.ui.main

import android.os.Build
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.sherlock.gb.kotlin.lesson2.AppState
import com.sherlock.gb.kotlin.lesson2.R
import com.sherlock.gb.kotlin.lesson2.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
        //fun newInstance(param1: String, param2: String) = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
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

        //viewModel.getWeather()
    }



    private fun renderData(data: Any) {
        /*
        when(appState){
            is AppState.Success->{
                val weatherData = appState.weatherData
                //loadingLayout.visibility = View.GONE
                //Snackbar.make(mainView,"Sucess", Snackbar.LENGTH_LONG).show())
            }
        }

         */
        Toast.makeText(context, "data", Toast.LENGTH_LONG).show()

    }
}