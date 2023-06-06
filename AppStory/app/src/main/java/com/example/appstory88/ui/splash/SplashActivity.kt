package com.example.appstory88.ui.splash

import android.content.Intent
import android.os.Bundle
import com.example.appstory88.R
import com.example.appstory88.base.BaseBindingActivity
import com.example.appstory88.databinding.ActivitySplashBinding
import com.example.appstory88.ui.MainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity: BaseBindingActivity<ActivitySplashBinding, SplashViewModel>() {
    private val splashScope = CoroutineScope(Dispatchers.Main)
    private val splashDelay: Long = 1000 // Delay time in milliseconds (e.g., 2000 = 2 seconds)


    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun setupView(savedInstanceState: Bundle?) {
        splashScope.launch {
            delay(splashDelay)

            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun setupData() {
    }

    override fun getViewModel(): Class<SplashViewModel> {
        return  SplashViewModel::class.java
    }

    override fun onDestroy() {
        super.onDestroy()
        splashScope.cancel()
    }
}