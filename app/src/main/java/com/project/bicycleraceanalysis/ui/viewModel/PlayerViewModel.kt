package com.project.bicycleraceanalysis.ui.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.project.bicycleraceanalysis.model.response.ResPlayerInfoItemDto
import com.project.bicycleraceanalysis.network.repository.PlayerRepoImpl
import com.project.bicycleraceanalysis.ui.base.BaseViewModel

class PlayerViewModel(private val repo : PlayerRepoImpl) : BaseViewModel(){

    private val _playerInfoList = MutableLiveData<ArrayList<ResPlayerInfoItemDto>>()
    val playerInfoListLiveData : LiveData<ArrayList<ResPlayerInfoItemDto>>
        get() = _playerInfoList


    fun getPlayerList(page:Int){
        addDisposable(
            repo.getPlayerList(
                page = page
            )
                .subscribe({ it ->
                    _playerInfoList.postValue(it)
                    it.forEach { dat ->
                        Log.d("data : ", dat.racer_nm)
                    }
                }, {
                    Log.d("TAG", it.message.toString())
                })
        )
    }

}