package com.hegunhee.mydatabinding

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

data class Model(var first_name: String, val second_name: String) {
    val text = MutableLiveData<String>("default")

    private val _intValue = MutableLiveData<Int>(0)
    val intValue: LiveData<Int>
        get() = _intValue

    fun onClick() {
        val value = intValue.value ?: return
        _intValue.value = value + 1
        Log.d("ClickTest", "click${intValue.toString()}")

    }

}
