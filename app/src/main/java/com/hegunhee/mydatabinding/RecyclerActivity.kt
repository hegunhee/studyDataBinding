package com.hegunhee.mydatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.hegunhee.mydatabinding.databinding.ActivityRecyclerBinding

class RecyclerActivity : AppCompatActivity() {
    private val viewModel by lazy {
        ViewModelProvider(this).get(RecyclerViewModel::class.java)
    }
    private lateinit var binding : ActivityRecyclerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_recycler)
        binding.apply {
            recyclerView.adapter = RecyclerAdapter()
            recyclerView.layoutManager = LinearLayoutManager(this@RecyclerActivity)
            viewmodel = viewModel
            lifecycleOwner = this@RecyclerActivity
        }



    }
}