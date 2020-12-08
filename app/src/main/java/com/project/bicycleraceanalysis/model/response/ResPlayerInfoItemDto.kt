package com.project.bicycleraceanalysis.model.response

data class ResPlayerInfoItemDto(
    val brk_rank1_cnt: Any,
    val care_cnt: Any,
    val down_po_cnt: String,
    val elim_cnt: String,
    val estm_scr: Any,
    val gear_rate: Any,
    val go_po_cnt: String,
    val high_3_rate: String, //3연대율
    val high_rate: String, //연대율
    val id: Int,
    val mrk_rank1_cnt: Any,
    val pas_rank1_cnt: Any,
    val period_no: String, //기수
    val pre_rank1_cnt: Any,
    val racer_grd: String,
    val racer_nm: String, //이름
    val racer_no: String,
    val rank_1_cnt: String,
    val rank_2_cnt: String,
    val rank_3_cnt: String,
    val rank_4_cnt: String,
    val rank_5_cnt: String,
    val rank_6_cnt: String,
    val rank_7_cnt: String,
    val rank_8_cnt: String,
    val rank_9_cnt: String,
    val run_cnt: String,
    val run_day_cnt: String,
    val stnd_year: String,
    val tot_rank: Any,
    val warn_cnt: Any,
    val win_rate: String //승률
)