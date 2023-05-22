package com.example.appstory88

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.appstory88.databinding.LayoutViewDescribeStoryBinding

class ViewDescribeStory : AppCompatActivity(){
    lateinit var binding:LayoutViewDescribeStoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.layout_view_describe_story)

    }
}