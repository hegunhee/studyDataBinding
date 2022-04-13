package com.hegunhee.mydatabinding

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RecyclerViewModel : ViewModel() {

    private val _movieList = MutableLiveData<ArrayList<Movie>>(arrayListOf(Movie("Title 0","Context 0")))
    val movieList: LiveData<ArrayList<Movie>>
        get() = _movieList


    fun addData() {
        _movieList.value?.add(
            Movie(
                "Title ${movieList.value?.size}",
                "Content ${movieList.value?.size}"
            )
        )
        _movieList.value = _movieList.value!!
    }

}