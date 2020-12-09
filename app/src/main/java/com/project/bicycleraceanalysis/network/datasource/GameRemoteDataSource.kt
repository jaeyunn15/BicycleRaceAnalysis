package com.project.bicycleraceanalysis.network.datasource

import com.project.bicycleraceanalysis.model.response.ResGameDayListDto
import com.project.bicycleraceanalysis.model.response.ResGameInfoListDto
import io.reactivex.Single

interface GameRemoteDataSource {
    fun getGameList(page:Int) : Single<ResGameInfoListDto>
    fun getGameDayList(year:Int,month:Int,day:Int) : Single<ResGameDayListDto>
}