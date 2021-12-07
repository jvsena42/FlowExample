package com.example.flow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlin.time.Duration

class MainViewModel : ViewModel() {

    private val _livedata = MutableLiveData("Hello World")
    val liveData: LiveData<String> = _livedata

    private val _stateFlow = MutableStateFlow("Hello World")
    val stateFlow = _stateFlow.asStateFlow()

    //Is more used to send one time events
    private val _sharedFlow = MutableSharedFlow<String>()
    val sharedFlow = _sharedFlow.asSharedFlow()

    fun triggerLiveData() {
        _livedata.value = "Livedata"
    }

    /*It automatically emit the value when the activity is recreated*/
    fun triggerStateFlow() {
        _stateFlow.value = "StateFlow"
    }

    // The flow dont hold state
    fun triggerFlow(): Flow<String> {
        return flow {
            repeat(5) {
                emit("item $it")
                kotlinx.coroutines.delay(1000L)
            }
        }
    }

    fun triggerSharedFlow() {
        viewModelScope.launch {
            _sharedFlow.emit("SharedFlow")
        }
    }
}