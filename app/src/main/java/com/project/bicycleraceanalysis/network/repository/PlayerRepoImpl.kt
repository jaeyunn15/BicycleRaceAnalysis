package com.project.bicycleraceanalysis.network.repository

import com.project.bicycleraceanalysis.model.response.ResPlayerInfoListDto
import com.project.bicycleraceanalysis.network.datasource.PlayersRemoteDataSource
import io.reactivex.Single

class PlayerRepoImpl (private val playersRemoteDataSource: PlayersRemoteDataSource) : PlayerRepo{
    override fun getPlayerList(page: Int): Single<ResPlayerInfoListDto> {
        return playersRemoteDataSource.getPlayersList(page)
    }

}