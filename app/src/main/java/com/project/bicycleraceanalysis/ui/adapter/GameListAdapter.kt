package com.project.bicycleraceanalysis.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.project.bicycleraceanalysis.R
import com.project.bicycleraceanalysis.databinding.ViewGameInfoBinding
import com.project.bicycleraceanalysis.model.response.ResGameInfoItemDto
import com.project.bicycleraceanalysis.model.response.ResPlayerInfoItemDto
import com.project.bicycleraceanalysis.util.getConvert

class GameListAdapter : RecyclerView.Adapter<GameListAdapter.GameInfoViewHolder>() {

    private var gameInfoList : ArrayList<ResGameInfoItemDto> = ArrayList()

    private var listener: ((year: Int, month: Int, day: Int) -> Unit)? = null

    fun setOnItemClickListener(listener: (year: Int, month: Int, day: Int) -> Unit) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameListAdapter.GameInfoViewHolder {
        val binding: ViewGameInfoBinding
                = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.view_game_info, parent, false)
        return GameInfoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GameListAdapter.GameInfoViewHolder, position: Int) {
        holder.onBind(gameInfoList[position], position)
    }

    fun setGameData(data : ArrayList<ResGameInfoItemDto>){
        this.gameInfoList = data
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = gameInfoList.size

    inner class GameInfoViewHolder(private val binding: ViewGameInfoBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun onBind(item: ResGameInfoItemDto, position: Int) {
            binding.apply {
                this.data = item
                binding.tvScheduleDay.text = item.schedule_year+"/"+item.schedule_month+"/"+item.schedule_day
            }
            itemView.setOnClickListener {
                listener?.invoke(
                    Integer.parseInt(item.schedule_year),
                    getConvert(Integer.parseInt(item.schedule_month)),
                    getConvert(Integer.parseInt(item.schedule_day))
                )
            }
        }
    }

}