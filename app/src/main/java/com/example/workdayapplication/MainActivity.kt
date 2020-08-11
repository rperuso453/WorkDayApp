package com.example.workdayapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.workDayStringLiveData.observe(this, Observer {
            urlId.text = it
        })
        viewModel.getUrl()
        urlId.setOnClickListener(View.OnClickListener {
            Toast.makeText(applicationContext, "click", Toast.LENGTH_SHORT).show()
            viewModel.getUrl()
            urlId.text = viewModel.workDayStringLiveData.value
        })
    }
}