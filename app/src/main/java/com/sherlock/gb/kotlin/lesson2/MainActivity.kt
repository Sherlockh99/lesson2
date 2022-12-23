package com.sherlock.gb.kotlin.lesson2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sherlock.gb.kotlin.lesson2.databinding.FragmentMainBinding
import com.sherlock.gb.kotlin.lesson2.ui.main.MainFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: FragmentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container,MainFragment.newInstance())
                .commit()
        }
    }

}