package com.project.bicycleraceanalysis.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.project.bicycleraceanalysis.ui.base.BaseViewModel

class SharedViewModel : BaseViewModel(){
    val player_id = MutableLiveData<Int>()
    val player_id_LiveData : LiveData<Int>
        get() = player_id

    val game_year = MutableLiveData<Int>()
    val game_year_LiveData : LiveData<Int>
        get() = game_year

    val game_month = MutableLiveData<Int>()
    val game_month_LiveData : LiveData<Int>
        get() = game_month

    val game_day = MutableLiveData<Int>()
    val game_day_LiveData : LiveData<Int>
        get() = game_day

}