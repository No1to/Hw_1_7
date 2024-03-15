package com.example.hw_1_7.domain.models.camera

data class CameraModel(
    var id:Int ?= null,
    var data: Data,
    var success: Boolean
){
    data class Data(
        var cameras: List<Camera>,
        val room: List<String>
    ){
        data class Camera(
            val favorites: Boolean,
            val id: Int,
            val name: String,
            val rec: Boolean,
            val room: String,
            val snapshot: String
        )
    }
}

