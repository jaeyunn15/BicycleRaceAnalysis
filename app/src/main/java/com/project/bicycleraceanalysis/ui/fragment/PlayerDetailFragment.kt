package com.project.bicycleraceanalysis.ui.fragment

import android.view.View
import com.project.bicycleraceanalysis.R
import com.project.bicycleraceanalysis.databinding.FragmentPlayerDetailBinding
import com.project.bicycleraceanalysis.ui.base.BaseFragment
import com.project.bicycleraceanalysis.ui.viewModel.PlayerViewModel
import com.project.bicycleraceanalysis.util.getAgeFromYear
import org.koin.android.ext.android.inject

class PlayerDetailFragment : BaseFragment<FragmentPlayerDetailBinding, PlayerViewModel>() {
    override val layoutResourceId: Int
        get() = R.layout.fragment_player_detail

    override val viewModel: PlayerViewModel by inject()

    override fun initStartView() {
        mainActivity.setBottomNavigationVisibility(View.GONE)
        sharedViewModel.player_id_LiveData.observe(viewLifecycleOwner){
            viewModel.getPlayerDetailInfo(it)
        }
    }

    override fun initDataBinding() {
        viewModel._playerDetailInfoLiveData.observe(viewLifecycleOwner){
            viewDataBinding.data = it
            viewDataBinding.tvPlayerAge.text = getAgeFromYear(it.stnd_year).toString()
        }
    }

    override fun initAfterBinding() {
    }

    override fun onDestroy() {
        super.onDestroy()
        mainActivity.setBottomNavigationVisibility(View.VISIBLE)
    }
}