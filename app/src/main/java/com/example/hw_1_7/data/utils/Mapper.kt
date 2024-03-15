package com.example.hw_1_7.data.utils

import com.example.hw_1_7.domain.models.camera.CameraModel
import com.example.hw_1_7.domain.models.door.DoorModel

fun CameraModel.mapToCameraModel() =
    CameraModel(
        id = id,
        data = data,
        success = success
    )

fun DoorModel.mapToDoorModel() =
    DoorModel(
        id = id,
        data = data,
        success = success
    )