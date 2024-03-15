package com.example.hw_1_7.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "camera_data")
data class CameraData(
    @PrimaryKey
    var id: Int? = null,
    val count: Int,
)
