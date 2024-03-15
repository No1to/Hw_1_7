package com.example.hw_1_7.domain.usecases

import com.example.hw_1_7.domain.repositories.DoorsRepository
import javax.inject.Inject

class GetDoorsUseCase @Inject constructor(
    private val doorsRepository: DoorsRepository
) {
    suspend fun getDoors() = doorsRepository.getDoors()
}