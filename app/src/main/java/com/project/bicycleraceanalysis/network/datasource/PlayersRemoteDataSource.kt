package com.project.bicycleraceanalysis.network.datasource


import com.project.bicycleraceanalysis.model.response.ResPlayerInfoListDto
import io.reactivex.Single

interface PlayersRemoteDataSource {
    fun getPlayersList(page:Int) : Single<ResPlayerInfoListDto>
}