package com.project.bicycleraceanalysis.network.datasource

import com.project.bicycleraceanalysis.model.response.ResGameDayListDto
import com.project.bicycleraceanalysis.model.response.ResGameInfoListDto
import com.project.bicycleraceanalysis.network.api.GameApi
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GameRemoteDataSourceImpl(private val gameApi : GameApi) : GameRemoteDataSource{
    override fun getGameList(page: Int): Single<ResGameInfoListDto> {
        return gameApi.getGameList(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    override fun getGameDayList(year: Int, month: Int, day: Int): Single<ResGameDayListDto> {
        return gameApi.getGameDayList(year, month, day)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}
