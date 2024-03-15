package com.example.hw_1_7.presentation.cameras

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.example.hw_1_7.data.local.HomeDao
import com.example.hw_1_7.data.local.models.DoorData
import com.example.hw_1_7.databinding.FragmentCameraBinding
import com.example.hw_1_7.domain.utils.UiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class CameraFragment :Fragment() {
    private lateinit var binding: FragmentCameraBinding
    private val viewModel: CameraViewModel by viewModels()
    private val adapter = CameraAdapter()
    @Inject
    lateinit var dao: HomeDao

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCameraBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRequest()
        binding.recyclerView.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.camerasFlow.collect{
                when(it){
                    is UiState.Empty -> {
                        adapter.submitList(emptyList())
                        adapter.notifyDataSetChanged()
                    }
                    is UiState.Error -> {
                        Toast.makeText(requireContext(), "Произошла ошибка", Toast.LENGTH_LONG).show()
                    }
                    is UiState.Loading -> {}
                    is UiState.Success -> {
                        if (dao.getDoorCount() == 0) {
                            viewModel.viewModelScope.launch {
                                viewModel.getCameras()
                                adapter.submitList(it.data?.data?.cameras)
                                val data = DoorData(
                                    count = adapter.currentList.size
                                )
                                dao.insertDoorData(data)
                            }
                        }else{
                            binding.cameraRefreshLayout.setOnRefreshListener {
                                viewModel.viewModelScope.launch {
                                    viewModel.getCameras()
                                    adapter.submitList(it.data?.data?.cameras)
                                }
                                binding.cameraRefreshLayout.isRefreshing = false
                            }
                        }
                    }
                }
            }
        }

    }

    private fun initRequest() {
        viewModel.viewModelScope.launch { viewModel.getCameras() }
    }
}