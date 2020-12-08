package com.project.bicycleraceanalysis.di

import com.project.bicycleraceanalysis.network.datasource.GameRemoteDataSource
import com.project.bicycleraceanalysis.network.datasource.GameRemoteDataSourceImpl
import com.project.bicycleraceanalysis.network.datasource.PlayersRemoteDataSource
import com.project.bicycleraceanalysis.network.datasource.PlayersRemoteDataSourceImpl
import org.koin.dsl.module

val remoteDataSourceModule = module {
    single<PlayersRemoteDataSource>{ PlayersRemoteDataSourceImpl(get()) }
    single<GameRemoteDataSource>{ GameRemoteDataSourceImpl(get()) }
}