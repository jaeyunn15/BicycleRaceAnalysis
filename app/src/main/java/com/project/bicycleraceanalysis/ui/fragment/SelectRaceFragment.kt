package com.project.bicycleraceanalysis.ui.fragment

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.bicycleraceanalysis.R
import com.project.bicycleraceanalysis.databinding.FragmentSelectRaceBinding
import com.project.bicycleraceanalysis.ui.adapter.RaceListAdapter
import com.project.bicycleraceanalysis.ui.base.BaseFragment
import com.project.bicycleraceanalysis.ui.viewModel.GameViewModel
import org.koin.android.ext.android.inject
import kotlin.properties.Delegates


class SelectRaceFragment : BaseFragment<FragmentSelectRaceBinding, GameViewModel>() {
    override val layoutResourceId: Int
        get() = R.layout.fragment_select_race

    override val viewModel: GameViewModel by inject()

    var game_year by Delegates.notNull<Int>()
    var game_month by Delegates.notNull<Int>()
    var game_day by Delegates.notNull<Int>()

    private val raceListAdapter = RaceListAdapter()

    override fun initStartView() {
        sharedViewModel.game_year_LiveData.observe(viewLifecycleOwner){
            game_year = it
            Log.d("가져온 년도 ", it.toString())
        }
        sharedViewModel.game_month_LiveData.observe(viewLifecycleOwner){
            game_month = it
            Log.d("가져온 월 ", it.toString())
        }
        sharedViewModel.game_day_LiveData.observe(viewLifecycleOwner){
            game_day = it
            Log.d("가져온 날 ", it.toString())
            viewModel.getGameDayList(game_year,game_month,game_day)
        }

        viewDataBinding.rvRaceInfo.run {
            layoutManager = GridLayoutManager(requireContext(),3).apply {
                orientation = GridLayoutManager.VERTICAL
            }
            adapter = raceListAdapter
            setHasFixedSize(true)
        }
    }

    override fun initDataBinding() {
        viewModel.ifRaceInfoHasLiveData.observe(viewLifecycleOwner){
            if (it){
                viewDataBinding.tvNoData1.visibility = View.GONE
                viewDataBinding.tvNoData2.visibility = View.GONE
                viewModel.raceInfoListLiveData.observe(viewLifecycleOwner){
                    raceListAdapter.setRaceInfo(it)
                }
            }else{
                viewDataBinding.tvNoData1.visibility = View.VISIBLE
                viewDataBinding.tvNoData2.visibility = View.VISIBLE
            }
        }

    }

    override fun initAfterBinding() {
    }


}