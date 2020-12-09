package com.project.bicycleraceanalysis.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.project.bicycleraceanalysis.R
import com.project.bicycleraceanalysis.databinding.ViewRaceInfoBinding
import com.project.bicycleraceanalysis.model.response.ResGameDayItemDto

class RaceListAdapter : RecyclerView.Adapter<RaceListAdapter.RaceInfoViewHolder>() {

    private var raceInfoList : ArrayList<ResGameDayItemDto> = ArrayList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RaceListAdapter.RaceInfoViewHolder {
        val binding: ViewRaceInfoBinding
                = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.view_race_info, parent, false)
        return RaceInfoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RaceListAdapter.RaceInfoViewHolder, position: Int) {
        holder.onBind(raceInfoList[position], position)
    }

    override fun getItemCount(): Int = raceInfoList.size

    fun setRaceInfo(data : ArrayList<ResGameDayItemDto>){
        this.raceInfoList = data
        notifyDataSetChanged()
    }

    inner class RaceInfoViewHolder(private val binding: ViewRaceInfoBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun onBind(item: ResGameDayItemDto, position: Int) {
            binding.apply {
                this.data = item
            }
            itemView.setOnClickListener {
                //
            }
        }
    }
}