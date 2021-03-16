package com.trackrider.android.ilabankdemoapp.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import com.trackrider.android.ilabankdemoapp.R
import com.trackrider.android.ilabankdemoapp.databinding.ActivityMainBinding
import com.trackrider.android.ilabankdemoapp.ui.base.BaseActivity

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override val mViewModel: MainViewModel by viewModels()
    override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)


}