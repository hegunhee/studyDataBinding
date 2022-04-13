package com.hegunhee.mydatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.hegunhee.mydatabinding.databinding.ActivityLiveDataBinding

class LiveDataActivity : AppCompatActivity() {
    private val viewModel by lazy {
        ViewModelProvider(this).get(LivedataViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityLiveDataBinding = DataBindingUtil.setContentView(this,R.layout.activity_live_data)
        binding.apply {
            lifecycleOwner = this@LiveDataActivity
            viewmodel = viewModel
        }
    }
}