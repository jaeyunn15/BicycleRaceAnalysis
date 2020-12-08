package com.project.bicycleraceanalysis

import android.app.Application
import com.project.bicycleraceanalysis.di.networkModule
import com.project.bicycleraceanalysis.di.remoteDataSourceModule
import com.project.bicycleraceanalysis.di.repositoryModule
import com.project.bicycleraceanalysis.di.viewModelModule
import com.project.bicycleraceanalysis.util.setupKoin

class BicycleRaceAnalysisApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        setupKoin(
            this,
            networkModule,
            remoteDataSourceModule,
            repositoryModule,
            viewModelModule
        )
    }
}