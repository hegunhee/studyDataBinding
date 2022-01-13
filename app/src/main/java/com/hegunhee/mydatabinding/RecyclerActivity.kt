package com.hegunhee.mydatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.LinearLayoutManager
import com.hegunhee.mydatabinding.databinding.ActivityRecyclerBinding

class RecyclerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityRecyclerBinding= DataBindingUtil.setContentView(this,R.layout.activity_recycler)
        val myAdapter = RecyclerAdapter()
        val movieList = ObservableArrayList<Movie>()
        for(i in 0 until 5){
            movieList.add(Movie("Title $i","Content $i"))
        }
        binding.recyclerView.adapter = myAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.movieList = movieList


    }
}