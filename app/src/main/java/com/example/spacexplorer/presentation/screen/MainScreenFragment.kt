package com.example.spacexplorer.presentation.screen

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.spacexplorer.databinding.FragmentMainScreenBinding
import com.example.spacexplorer.presentation.contracts.MainScreenContract
import com.example.spacexplorer.presentation.screen.adapters.MainScreenAdapter
import com.example.spacexplorer.presentation.screen.viewmodels.MainScreenMVIViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@AndroidEntryPoint
class MainScreenFragment : Fragment() {
    private var _binding: FragmentMainScreenBinding? = null
    private val binding: FragmentMainScreenBinding
        get() = _binding ?: throw Exception("FragmentMaiScreenBinding is null")
    private val adapter = MainScreenAdapter()
    private var clockJob: Job? = null
    private val timeFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())

    //private val viewModel: MainScreenViewModel by viewModels()
    private val viewModel: MainScreenMVIViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        startClock()
        collectState()
        loadLaunches()
    }

    private fun setupRecyclerView() {
        binding.rvLaunchList.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvLaunchList.adapter = adapter
    }

    private fun startClock() {
        clockJob = CoroutineScope(Dispatchers.Main).launch {
            while (isActive) {
                val currentTime = timeFormat.format(Date())
                binding.tvCurrentTime.text = currentTime
                delay(1000)
            }
        }
    }

    private fun collectState() {
        lifecycleScope.launch {
            viewModel.effect.collect { effect ->
                when (effect) {
                    is MainScreenContract.Effect.ShowError -> {
                        Toast.makeText(requireContext(), effect.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
        lifecycleScope.launch {
            viewModel.viewState.collect { state ->
                adapter.submitList(state.launches)
            }
        }
    }

    private fun loadLaunches() {
        viewModel.setEvent(MainScreenContract.Event.LoadLaunches)
    }


    /*  private fun collectState() {
          viewModel.state.onEach { state ->
              adapter.submitList(state.models)
          }.launchIn(lifecycleScope)
      }*/

    override fun onDestroyView() {
        super.onDestroyView()
        clockJob?.cancel()
        _binding = null
    }
}