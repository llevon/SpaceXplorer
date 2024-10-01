package com.example.spacexplorer.domain.models


import java.time.LocalDateTime

data class LaunchInfoModel(
    val name: String,
    val time: LocalDateTime,
    val details: String,
    var status: String?
)

