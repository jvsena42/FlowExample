package com.example.flow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.flow.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMainBinding
    private lateinit var _viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        _viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        onClickListeners()
    }

    private fun onClickListeners() = _binding.run {

        liveDataBtn.setOnClickListener {
            _viewModel.triggerLiveData()
        }

        stateFlowBtn.setOnClickListener {
            _viewModel.triggerStateFlow()
        }

        flowBtn.setOnClickListener {
            _viewModel.triggerFlow()
        }

        sharedFlowBtn.setOnClickListener {
            _viewModel.triggerSharedFlow()
        }
    }
}