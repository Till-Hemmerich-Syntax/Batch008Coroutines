package com.syntax.hemmerich.batch008coroutines.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.delay

class Repository {

    private val _image = MutableLiveData<String>()
    val image : LiveData<String>
        get() = _image

     suspend fun loadImage(){
        delay(5000)
        _image.postValue("Stell dir vor ich bin ein tolles Image :-)")
    }

}