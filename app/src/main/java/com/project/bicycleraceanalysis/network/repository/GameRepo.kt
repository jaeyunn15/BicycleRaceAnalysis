package com.project.bicycleraceanalysis.network.repository

import com.project.bicycleraceanalysis.model.response.ResGameInfoListDto
import io.reactivex.Single

interface GameRepo {
    fun getGameList(page:Int) : Single<ResGameInfoListDto>
}