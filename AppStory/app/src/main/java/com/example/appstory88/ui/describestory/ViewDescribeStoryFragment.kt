package com.example.appstory88.ui.describestory

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.appstory88.R
import com.example.appstory88.databinding.LayoutViewDescribeStoryBinding
import com.example.appstory88.ui.detailstory.DetailStoryActivity

class ViewDescribeStoryFragment : AppCompatActivity(){
    lateinit var binding:LayoutViewDescribeStoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this, R.layout.layout_view_describe_story)
        binding.tvReadStory.setOnClickListener {
            var intent = Intent(this, DetailStoryActivity::class.java)

            startActivity(intent)
        }

    }
}