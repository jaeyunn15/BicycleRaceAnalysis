package com.project.bicycleraceanalysis.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.project.bicycleraceanalysis.R
import com.project.bicycleraceanalysis.databinding.ViewPlayerInfoBinding
import com.project.bicycleraceanalysis.model.response.ResPlayerInfoItemDto
import com.project.bicycleraceanalysis.util.getAgeFromYear
import org.koin.ext.getScopeName

class PlayerListAdapter () : RecyclerView.Adapter<PlayerListAdapter.PlayerInfoViewHolder>() {

    private var playerInfoList : ArrayList<ResPlayerInfoItemDto> = ArrayList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlayerListAdapter.PlayerInfoViewHolder {
        val binding: ViewPlayerInfoBinding
                = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.view_player_info, parent, false)
        return PlayerInfoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlayerListAdapter.PlayerInfoViewHolder, position: Int) {
        holder.onBind(playerInfoList[position], position)
    }

    override fun getItemCount(): Int = playerInfoList.size

    fun setPlayerInfoData(data : ArrayList<ResPlayerInfoItemDto>){
        this.playerInfoList = data
        notifyDataSetChanged()
    }

    inner class PlayerInfoViewHolder(private val binding: ViewPlayerInfoBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun onBind(item: ResPlayerInfoItemDto, position: Int) {
            binding.apply {
                this.item = item
                binding.tvPlayerAge.text = getAgeFromYear(item.stnd_year).toString()
            }
            itemView.setOnClickListener {
                //
            }
        }
    }

}