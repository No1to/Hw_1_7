package com.example.hw_1_7.domain.repositories

import com.example.hw_1_7.data.utils.Resource
import com.example.hw_1_7.domain.models.door.DoorModel
import kotlinx.coroutines.flow.Flow

interface DoorsRepository {
    suspend fun getDoors(): Flow<Resource<DoorModel>>
}