package com.example.appstory88.ui.splash

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.WindowManager
import com.example.appstory88.R
import com.example.appstory88.base.BaseBindingActivity
import com.example.appstory88.databinding.ActivitySplashBinding
import com.example.appstory88.ui.MainActivity

class SplashActivity : BaseBindingActivity<ActivitySplashBinding, SplashViewModel>() {
    lateinit var binding: ActivitySplashBinding

    var handle: Handler? = null
    var runable: Runnable? = null


    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun setupView(savedInstanceState: Bundle?) {
        makeStatusBarLight(this, Color.parseColor("#45ABF6"))
        startToMain()

    }

    override fun setupData() {
    }

    override fun getViewModel(): Class<SplashViewModel> {
        return SplashViewModel::class.java
    }

    private fun makeStatusBarLight(activity: Activity, color: Int) {
        val window = activity.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor = color
        activity.window.decorView.systemUiVisibility =
            (View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
    }

    override fun onDestroy() {
        super.onDestroy()
        handle?.removeCallbacksAndMessages(null)
    }

    private fun startToMain() {
        // Cho 1 khoang thoi gian moi thuc hien hanh dong
        handle?.removeCallbacksAndMessages(null)
        handle = Handler(Looper.getMainLooper())
        runable = Runnable {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        runable?.let {
            handle?.postDelayed(it, 3000)
        }

    }
}