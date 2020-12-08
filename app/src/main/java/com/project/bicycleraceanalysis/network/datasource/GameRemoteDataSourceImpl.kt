package com.project.bicycleraceanalysis.network.datasource

import com.project.bicycleraceanalysis.model.response.ResGameInfoListDto
import com.project.bicycleraceanalysis.network.api.GameApi
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GameRemoteDataSourceImpl(private val gameApi : GameApi) : GameRemoteDataSource{
    override fun getGameList(page: Int): Single<ResGameInfoListDto> {
        return gameApi.getPlayersList(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}
