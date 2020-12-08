package com.project.bicycleraceanalysis.network.api

import com.project.bicycleraceanalysis.model.response.ResGameInfoListDto
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GameApi {

    @GET("schedules/{page}")
    fun getPlayersList(
            @Path("page")page : Int
    ): Single<ResGameInfoListDto>

}