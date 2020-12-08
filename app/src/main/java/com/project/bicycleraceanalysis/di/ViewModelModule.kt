package com.project.bicycleraceanalysis.di

import com.project.bicycleraceanalysis.ui.viewModel.GameViewModel
import com.project.bicycleraceanalysis.ui.viewModel.PlayerViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { PlayerViewModel(get()) }
    viewModel { GameViewModel(get()) }
}
