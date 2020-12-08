package com.project.bicycleraceanalysis.network.repository

import com.project.bicycleraceanalysis.model.response.ResGameInfoListDto
import com.project.bicycleraceanalysis.network.datasource.GameRemoteDataSource
import io.reactivex.Single

class GameRepoImpl (private val repo : GameRemoteDataSource) : GameRepo{
    override fun getGameList(page: Int): Single<ResGameInfoListDto> {
        return repo.getGameList(page)
    }
}