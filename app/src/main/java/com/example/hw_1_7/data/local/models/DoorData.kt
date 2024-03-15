package com.example.hw_1_7.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "door_data")
data class DoorData(
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null,
    val count:Int
)
