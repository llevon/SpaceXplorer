package com.example.spacexplorer.domain.usecases

import com.example.spacexplorer.domain.models.LaunchInfoModel
import com.example.spacexplorer.domain.repositories.GetLaunchInfoRepository
import kotlinx.coroutines.flow.Flow

class GetLaunchInfoUseCase(
     private val getLaunchInfoRepository: GetLaunchInfoRepository

) {
operator fun invoke(): Flow<List<LaunchInfoModel>> {
     return getLaunchInfoRepository.getLaunchInfo()
}
}