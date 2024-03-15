package com.example.hw_1_7.domain.usecases

import com.example.hw_1_7.domain.repositories.CamerasRepository
import javax.inject.Inject

class GetCamerasUseCase @Inject constructor(
    private val camerasRepository: CamerasRepository
) {
    suspend fun getCameras() = camerasRepository.getCameras()
}