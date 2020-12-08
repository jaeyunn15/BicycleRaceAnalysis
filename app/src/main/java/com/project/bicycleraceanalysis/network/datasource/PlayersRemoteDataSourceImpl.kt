package com.project.bicycleraceanalysis.network.datasource

import com.project.bicycleraceanalysis.model.response.ResPlayerInfoListDto
import com.project.bicycleraceanalysis.network.api.PlayerApi
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PlayersRemoteDataSourceImpl (private val playerApi: PlayerApi) : PlayersRemoteDataSource {

    override fun getPlayersList(page: Int): Single<ResPlayerInfoListDto> {
        return playerApi.getPlayersList(page = page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}