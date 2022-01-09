package com.hegunhee.mydatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.hegunhee.mydatabinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding  : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        val model = Model("firstName","secondName")
        binding.model = model
        model.first_name = "no way"
    }
}