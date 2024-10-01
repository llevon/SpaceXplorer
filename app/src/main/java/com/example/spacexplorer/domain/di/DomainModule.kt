package com.example.spacexplorer.domain.di

import com.example.spacexplorer.domain.repositories.GetLaunchInfoRepository
import com.example.spacexplorer.domain.usecases.GetLaunchInfoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DomainModule{
    @Provides
    @Singleton
    fun providesGetLaunchInfoUseCase(getLaunchInfoRepository: GetLaunchInfoRepository) = GetLaunchInfoUseCase(getLaunchInfoRepository)
}
