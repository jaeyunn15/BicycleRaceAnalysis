package com.project.bicycleraceanalysis.ui.fragment

import androidx.recyclerview.widget.LinearLayoutManager
import com.project.bicycleraceanalysis.R
import com.project.bicycleraceanalysis.databinding.FragmentGameBinding
import com.project.bicycleraceanalysis.ui.adapter.GameListAdapter
import com.project.bicycleraceanalysis.ui.base.BaseFragment
import com.project.bicycleraceanalysis.ui.viewModel.GameViewModel
import org.koin.android.ext.android.inject


class GameFragment : BaseFragment<FragmentGameBinding, GameViewModel>() {

    override val layoutResourceId: Int
        get() = R.layout.fragment_game

    override val viewModel: GameViewModel by inject()

    private val gameListAdapter = GameListAdapter()

    override fun initStartView() {
        viewModel.getGameList(1)
        viewDataBinding.rvGameInfo.run {
            layoutManager = LinearLayoutManager(requireContext()).apply {
                orientation = LinearLayoutManager.VERTICAL
            }
            adapter = gameListAdapter
            setHasFixedSize(true)
        }
    }

    override fun initDataBinding() {
        viewModel.gameInfoListLiveData.observe(viewLifecycleOwner){
            gameListAdapter.setGameData(it)
        }
    }

    override fun initAfterBinding() {
        val gameDayList = SelectRaceFragment()
        gameListAdapter.setOnItemClickListener { year, month, day ->
            sharedViewModel.game_year.postValue(year)
            sharedViewModel.game_month.postValue(month)
            sharedViewModel.game_day.postValue(day)
            replaceFrag(gameDayList)
        }
    }


}