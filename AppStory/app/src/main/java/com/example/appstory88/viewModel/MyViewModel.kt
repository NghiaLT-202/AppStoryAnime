package com.example.appstory88.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    private val _myData = MutableLiveData<String>()
    val myData: LiveData<String> = _myData

    fun updateData(data: String) {
        _myData.value = data
    }
}
