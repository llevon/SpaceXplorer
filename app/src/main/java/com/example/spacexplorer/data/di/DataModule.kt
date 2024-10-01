package com.example.spacexplorer.data.di

import com.example.spacexplorer.data.repositories.GetLaunchInfoRepositoryImpl
import com.example.spacexplorer.domain.repositories.GetLaunchInfoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    @Singleton
    fun provideGetLaunchInfoRepository(): GetLaunchInfoRepository {
        return GetLaunchInfoRepositoryImpl()
    }
}
