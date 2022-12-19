package com.sherlock.gb.kotlin.lesson2.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.sherlock.gb.kotlin.lesson2.R

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        /**
        Создадим инстанс Observer, который выполнит метод renderData, как только LiveData обновляет данные, которые она хранит,
        В качестве аргумента renderData принимает объект, возвращаемый лайвдатой
         */
        val observer = Observer<Any> { renderData(it) }
        /**
         *Вызываем у созданной ViewModel метод getData, возвращающий нам LiveData,
         * и вызываем у LiveData метод observe, который и передаём в жизненный цикл вместе с Observer
         */
        viewModel.getData().observe(viewLifecycleOwner, observer)
        /**
         * Теперь, если данные, которые хранит LiveData, изменятся,
         * Observer сразу об этом узнает и вызовет метод renderData, куда передаст новые данные.
         */
    }

    private fun renderData(data: Any) {
        Toast.makeText(context, "data", Toast.LENGTH_LONG).show()
    }
}