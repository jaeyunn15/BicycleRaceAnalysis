package com.project.bicycleraceanalysis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.project.bicycleraceanalysis.databinding.ActivityMainBinding
import com.project.bicycleraceanalysis.ui.fragment.GameFragment
import com.project.bicycleraceanalysis.ui.fragment.PlayerFragment
import com.project.bicycleraceanalysis.ui.viewModel.PlayerViewModel
import com.project.bicycleraceanalysis.util.replace
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    lateinit var navView: BottomNavigationView
    lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        replaceFragment(playerFragment)

        navView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item->
        when(item.itemId){
            R.id.navigation_player_list -> { replaceFragment(playerFragment) }
            R.id.navigation_game_list -> { replaceFragment(gameFragment) }
        }
        true
    }

    fun replaceFragment(fragment: androidx.fragment.app.Fragment){
        replace(R.id.container, fragment)
    }

    private val playerFragment : PlayerFragment by lazy { PlayerFragment() }
    private val gameFragment : GameFragment by lazy{ GameFragment() }
}