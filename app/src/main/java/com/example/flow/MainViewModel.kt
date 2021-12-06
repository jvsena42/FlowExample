package com.example.flow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class MainViewModel : ViewModel() {

    private val _livedata = MutableLiveData("Hello World")
    val liveData: LiveData<String> = _livedata

    private val _stateFlow = MutableStateFlow("Hello World")
    val stateFlow = _stateFlow

//    private val _sharedFlow = MutableSharedFlow<String>()
//    val sharedFlow = _sharedFlow

    fun triggerLiveData() {
        _livedata.value = "Livedata"
    }

    fun triggerStateFlow() {

    }

    fun triggerFlow() {

    }

    fun triggerSharedFlow() {

    }
}