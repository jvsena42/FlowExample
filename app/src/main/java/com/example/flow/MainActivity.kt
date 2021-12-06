package com.example.flow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.flow.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMainBinding
    private lateinit var _viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        _viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        onClickListeners()
        observe()
    }

    private fun observe() {
        _viewModel.liveData.observe(this) {
            _binding.liveDataTx.text = it
        }

        lifecycleScope.launchWhenStarted {
            _viewModel.stateFlow.collectLatest {
                _binding.stateFlowTx.text = it
            }
        }
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