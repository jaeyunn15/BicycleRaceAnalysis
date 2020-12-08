package com.project.bicycleraceanalysis.network.datasource

import com.project.bicycleraceanalysis.model.response.ResGameInfoListDto
import io.reactivex.Single

interface GameRemoteDataSource {
    fun getGameList(page:Int) : Single<ResGameInfoListDto>
}