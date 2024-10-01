package com.example.spacexplorer.domain.repositories

import com.example.spacexplorer.domain.models.LaunchInfoModel
import kotlinx.coroutines.flow.Flow

interface GetLaunchInfoRepository {
    fun getLaunchInfo(): Flow<List<LaunchInfoModel>>
}