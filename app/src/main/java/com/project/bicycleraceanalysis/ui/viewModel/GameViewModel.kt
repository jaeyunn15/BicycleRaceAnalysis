package com.project.bicycleraceanalysis.ui.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.project.bicycleraceanalysis.model.response.ResGameInfoListDto
import com.project.bicycleraceanalysis.network.repository.GameRepo
import com.project.bicycleraceanalysis.network.repository.GameRepoImpl
import com.project.bicycleraceanalysis.ui.base.BaseViewModel

class GameViewModel(private val repo : GameRepoImpl) : BaseViewModel(){

    private val _gameInfoList = MutableLiveData<ResGameInfoListDto>()
    val gameInfoListLiveData : LiveData<ResGameInfoListDto>
        get() = _gameInfoList

    fun getGameList(page:Int){
        addDisposable(
                repo.getGameList(page)
                        .subscribe({
                            _gameInfoList.postValue(it)
                            it.forEach {dat ->
                                Log.d("게임 데이터 : ", dat.title)
                            }
                        },{
                            Log.d("TAG ", it.localizedMessage)
                        })
        )
    }
}