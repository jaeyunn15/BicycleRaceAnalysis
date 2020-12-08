package com.project.bicycleraceanalysis.network.api

import com.project.bicycleraceanalysis.model.response.ResPlayerInfoListDto
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PlayerApi {

    @GET("players/{page}")
    fun getPlayersList(
        @Path("page")page : Int
    ): Single<ResPlayerInfoListDto>

}