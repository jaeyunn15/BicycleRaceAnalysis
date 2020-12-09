package com.project.bicycleraceanalysis.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.project.bicycleraceanalysis.MainActivity
import com.project.bicycleraceanalysis.ui.viewModel.SharedViewModel

abstract class BaseFragment<T : ViewDataBinding, R : BaseViewModel>() : Fragment(){
    lateinit var viewDataBinding: T

    abstract val layoutResourceId: Int

    abstract val viewModel: R

    lateinit var mainActivity: MainActivity

    lateinit var sharedViewModel: SharedViewModel

    abstract fun initStartView()

    abstract fun initDataBinding()

    abstract fun initAfterBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity = activity as MainActivity
        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBinding = DataBindingUtil.inflate(inflater,layoutResourceId, container, false)
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initStartView()
        initDataBinding()
        initAfterBinding()
    }

    fun replaceFrag(fragment: Fragment){
        mainActivity.replaceFragment(fragment)
    }

}