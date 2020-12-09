package com.project.bicycleraceanalysis.network.repository

import com.project.bicycleraceanalysis.model.response.ResPlayerInfoListDto
import io.reactivex.Single

interface PlayerRepo {
    fun getPlayerList(page:Int) : Single<ResPlayerInfoListDto>
    fun getPlayerDetailInfo(racer_no:Int) : Single<ResPlayerInfoListDto>
}