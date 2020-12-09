package com.project.bicycleraceanalysis.ui.fragment

import androidx.recyclerview.widget.LinearLayoutManager
import com.project.bicycleraceanalysis.R
import com.project.bicycleraceanalysis.databinding.FragmentPlayerBinding
import com.project.bicycleraceanalysis.ui.adapter.PlayerListAdapter
import com.project.bicycleraceanalysis.ui.base.BaseFragment
import com.project.bicycleraceanalysis.ui.viewModel.PlayerViewModel
import org.koin.android.ext.android.inject


class PlayerFragment : BaseFragment<FragmentPlayerBinding, PlayerViewModel>() {

    override val layoutResourceId: Int
        get() = R.layout.fragment_player

    override val viewModel: PlayerViewModel by inject()

    private val playerInfoAdapter = PlayerListAdapter()

    override fun initStartView() {
        viewModel.getPlayerList(1)
        viewDataBinding.rvPlayerInfo.run {
            layoutManager = LinearLayoutManager(requireContext()).apply {
                orientation = LinearLayoutManager.VERTICAL
            }
            adapter = playerInfoAdapter
            setHasFixedSize(true)
        }
    }

    override fun initDataBinding() {
        viewModel.playerInfoListLiveData.observe(viewLifecycleOwner){
            playerInfoAdapter.setPlayerInfoData(it)
        }
    }

    override fun initAfterBinding() {
        playerInfoAdapter.setOnItemClickListener {
            val playerDetail = PlayerDetailFragment()
            sharedViewModel.player_id.postValue(it)
            replaceFrag(playerDetail)
        }
    }


}