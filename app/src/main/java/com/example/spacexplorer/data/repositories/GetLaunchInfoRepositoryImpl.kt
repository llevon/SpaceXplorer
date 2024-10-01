package com.example.spacexplorer.data.repositories

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.spacexplorer.data.mappers.toLaunchInfoModel
import com.example.spacexplorer.data.models.myList
import com.example.spacexplorer.domain.models.LaunchInfoModel
import com.example.spacexplorer.domain.repositories.GetLaunchInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class GetLaunchInfoRepositoryImpl: GetLaunchInfoRepository {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun getLaunchInfo(): Flow<List<LaunchInfoModel>> {
        return flowOf(myList.toLaunchInfoModel())
    }
}