package com.example.appstory88.viewModel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MyActivity : AppCompatActivity() {
    private lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Khởi tạo ViewModel
        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        // Theo dõi LiveData
        viewModel.myData.observe(this, Observer { data ->
            // Thực hiện các hành động khi dữ liệu thay đổi
            // data chính là giá trị mới của LiveData
        })

        // Cập nhật dữ liệu trong ViewModel
        viewModel.updateData("New Data")
    }
}
