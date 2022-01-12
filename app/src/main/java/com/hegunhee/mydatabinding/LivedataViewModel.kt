package com.hegunhee.mydatabinding

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LivedataViewModel : ViewModel() {
    val first_data : MutableLiveData<String> = MutableLiveData("default")
    val second_data : MutableLiveData<String> = MutableLiveData("default")

    fun onClick(){
        second_data.value = first_data.value
        Log.d("click","clicked")
        Log.d("click","first_data value ${first_data.value}")
        Log.d("click","second_data value ${second_data.value}")
    }


}