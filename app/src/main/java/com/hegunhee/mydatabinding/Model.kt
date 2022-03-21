package com.hegunhee.mydatabinding

import android.util.Log
import androidx.lifecycle.MutableLiveData

data class Model(var first_name : String, val second_name : String) {
    val text = MutableLiveData<String>("default")

    var intValue = MutableLiveData<Int>(0)


    fun onClick(){
        intValue.value = intValue.value!!+1
        Log.d("ClickTest","click${intValue}")

    }

}
