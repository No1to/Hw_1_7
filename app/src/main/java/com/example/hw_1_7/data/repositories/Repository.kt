package com.example.hw_1_7.data.repositories

import com.example.hw_1_7.data.remote.ApiService
import com.example.hw_1_7.data.utils.Resource
import com.example.hw_1_7.data.utils.mapToCameraModel
import com.example.hw_1_7.data.utils.mapToDoorModel
import com.example.hw_1_7.domain.models.camera.CameraModel
import com.example.hw_1_7.domain.models.door.DoorModel
import com.example.hw_1_7.domain.repositories.CamerasRepository
import com.example.hw_1_7.domain.repositories.DoorsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class Repository(private val apiService: ApiService) : CamerasRepository, DoorsRepository {

    override suspend fun getCameras(): Flow<Resource<CameraModel>> =
        flow {
            emit(Resource.Loading())
            try {
                val result = apiService.getCameras().body()!!.mapToCameraModel()
                emit(Resource.Success(result))
            } catch (ex: Exception) {
                emit(Resource.Error(ex.message))
            }
        }

    override suspend fun getDoors(): Flow<Resource<DoorModel>> =
        flow {
            emit(Resource.Loading())
            try {
                val result = apiService.getDoors().body()!!.mapToDoorModel()
                emit(Resource.Success(result))
            }catch (ex:Exception){
                emit(Resource.Error(ex.message))
            }
        }
}