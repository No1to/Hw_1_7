package com.example.hw_1_7.domain.repositories

import com.example.hw_1_7.data.utils.Resource
import com.example.hw_1_7.domain.models.camera.CameraModel
import kotlinx.coroutines.flow.Flow

interface CamerasRepository {
    suspend fun getCameras(): Flow<Resource<CameraModel>>
}