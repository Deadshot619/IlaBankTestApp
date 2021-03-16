package com.trackrider.android.ilabankdemoapp.ui.splash

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.trackrider.android.ilabankdemoapp.R
import com.trackrider.android.ilabankdemoapp.databinding.FragmentSplashBinding
import com.trackrider.android.ilabankdemoapp.ui.base.BaseFragment
import com.trackrider.android.ilabankdemoapp.ui.main.MainActivity
import com.trackrider.android.ilabankdemoapp.ui.main.MainViewModel
import com.trackrider.android.ilabankdemoapp.utils.showToast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.ticker
import kotlinx.coroutines.launch

class SplashFragment : BaseFragment<MainViewModel, FragmentSplashBinding>() {

    companion object{
        private const val WAIT_IN_SPLASH = 3000L
    }

    override val mViewModel: MainViewModel by activityViewModels()
    override fun getViewBinding(): FragmentSplashBinding = FragmentSplashBinding.inflate(layoutInflater)

    private val mainScope = CoroutineScope(Dispatchers.Main)

    override fun onBinding() {}

    override fun onResume() {
        super.onResume()
        (activity as MainActivity).supportActionBar?.hide()

        goToHomePage()
    }

    private fun goToHomePage(){
        mainScope.launch {
            ticker(WAIT_IN_SPLASH).receive()
            findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToHomeFragment())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mainScope.cancel()
    }
}