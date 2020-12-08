package com.project.bicycleraceanalysis.di

import com.project.bicycleraceanalysis.network.repository.GameRepoImpl
import com.project.bicycleraceanalysis.network.repository.PlayerRepoImpl
import org.koin.dsl.module

val repositoryModule = module {
    single { PlayerRepoImpl(get()) }
    single { GameRepoImpl(get()) }
}