package com.example.hw_1_7.data.remote

import com.example.hw_1_7.domain.models.camera.CameraModel
import com.example.hw_1_7.domain.models.door.DoorModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("cameras/")
    suspend fun getCameras():Response<CameraModel>

    @GET("doors/")
    suspend fun getDoors():Response<DoorModel>
}