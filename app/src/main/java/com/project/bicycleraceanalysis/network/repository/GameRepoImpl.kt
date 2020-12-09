package com.project.bicycleraceanalysis.network.repository

import com.project.bicycleraceanalysis.model.response.ResGameDayListDto
import com.project.bicycleraceanalysis.model.response.ResGameInfoListDto
import com.project.bicycleraceanalysis.network.datasource.GameRemoteDataSource
import io.reactivex.Single

class GameRepoImpl (private val repo : GameRemoteDataSource) : GameRepo{
    override fun getGameList(page: Int): Single<ResGameInfoListDto> {
        return repo.getGameList(page)
    }

    override fun getGameDayList(year: Int, month: Int, day: Int): Single<ResGameDayListDto> {
        return repo.getGameDayList(year, month, day)
    }
}