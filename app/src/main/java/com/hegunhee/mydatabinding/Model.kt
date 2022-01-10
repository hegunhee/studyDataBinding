package com.hegunhee.mydatabinding

import android.util.Log

data class Model(var first_name : String, val second_name : String) {
    fun buttonClick(){
        Log.d("click","clicked")
    }
}
