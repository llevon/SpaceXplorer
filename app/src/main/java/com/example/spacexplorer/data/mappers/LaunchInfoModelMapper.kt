package com.example.spacexplorer.data.mappers

import com.example.spacexplorer.data.models.LaunchInfoModelDto
import com.example.spacexplorer.domain.models.LaunchInfoModel

fun LaunchInfoModelDto.toLaunchInfoModel(): LaunchInfoModel {
    return LaunchInfoModel(
        name = this.name,
        time = this.time,
        details = this.details,
        status = this.status
    )
}

fun List<LaunchInfoModelDto>.toLaunchInfoModel(): List<LaunchInfoModel> {
    return this.map { it.toLaunchInfoModel() }
}