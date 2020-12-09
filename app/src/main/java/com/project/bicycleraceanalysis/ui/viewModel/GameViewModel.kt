package com.project.bicycleraceanalysis.ui.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.project.bicycleraceanalysis.model.response.ResGameDayListDto
import com.project.bicycleraceanalysis.model.response.ResGameInfoListDto
import com.project.bicycleraceanalysis.network.repository.GameRepo
import com.project.bicycleraceanalysis.network.repository.GameRepoImpl
import com.project.bicycleraceanalysis.ui.base.BaseViewModel
import java.time.Year

class GameViewModel(private val repo : GameRepoImpl) : BaseViewModel(){

    private val _gameInfoList = MutableLiveData<ResGameInfoListDto>()
    val gameInfoListLiveData : LiveData<ResGameInfoListDto>
        get() = _gameInfoList

    private val _raceInfoList = MutableLiveData<ResGameDayListDto>()
    val raceInfoListLiveData : LiveData<ResGameDayListDto>
        get() = _raceInfoList

    private val _ifRaceInfoHas = MutableLiveData<Boolean>()
    val ifRaceInfoHasLiveData : LiveData<Boolean>
        get() = _ifRaceInfoHas


    fun getGameList(page:Int){
        addDisposable(
                repo.getGameList(page)
                        .subscribe({
                            _gameInfoList.postValue(it)
                        },{
                            Log.d("TAG ", it.localizedMessage)
                        })
        )
    }

    fun getGameDayList(year: Int, month:Int, day:Int){
        addDisposable(
            repo.getGameDayList(year, month, day)
                .subscribe({
                    if (it.isEmpty()){
                        Log.d("게임 일정 데이터 : ", "비었어")
                        _ifRaceInfoHas.postValue(false)
                    }
                    if (!it.isEmpty()){
                        _ifRaceInfoHas.postValue(true)
                        _raceInfoList.postValue(it)
                    }
                    it.forEach { dat ->
                        Log.d("게임 일정 데이터 : ", dat.race_no)
                    }
                },{
                    Log.d("TAG ", it.localizedMessage)
                })
        )
    }
}