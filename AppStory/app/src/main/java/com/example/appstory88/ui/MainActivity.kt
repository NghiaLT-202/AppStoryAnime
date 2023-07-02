package com.example.appstory88.ui

import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.appstory88.R
import com.example.appstory88.base.BaseBindingActivity
import com.example.appstory88.databinding.ActivityMainBinding

class MainActivity : BaseBindingActivity<ActivityMainBinding, MainViewModel>() {
    var navHostFragment: NavHostFragment? = null
    var navController: NavController? = null
    override fun getLayoutId(): Int {
        return R.layout.activity_main

    }

    override fun setupView(savedInstanceState: Bundle?) {
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment?
        navController = navHostFragment?.navController
    }

    override fun setupData() {
        viewModel.initData(this)

    }

    override fun getViewModel(): Class<MainViewModel> {
        return MainViewModel::class.java
    }


}


