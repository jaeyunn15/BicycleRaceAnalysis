package com.project.bicycleraceanalysis.network.api

import com.project.bicycleraceanalysis.model.response.ResGameDayListDto
import com.project.bicycleraceanalysis.model.response.ResGameInfoListDto
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GameApi {

    @GET("schedules/{page}")
    fun getGameList(
            @Path("page")page : Int
    ): Single<ResGameInfoListDto>

    @GET("races/{year}/{month}/{day}")
    fun getGameDayList(
        @Path("year")year : Int,
        @Path("month")month : Int,
        @Path("day")day : Int
    ): Single<ResGameDayListDto>

    @GET("results/{year}/{month}/{day}/{race_num}")
    fun getGameResultList(
        @Path("year")year : Int,
        @Path("month")month : Int,
        @Path("day")day : Int
    ): Single<ResGameInfoListDto>
}