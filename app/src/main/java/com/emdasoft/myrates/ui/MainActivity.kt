package com.emdasoft.myrates.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.emdasoft.myrates.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

//        recycleSetup()

        viewPagerSetup()
    }

    private fun viewPagerSetup(){
        binding.viewPager2.adapter = MainAdapter()

        viewModel.getRates()

        viewModel.rateList.observe(this) { list ->

            list.body()?.rates?.let { (binding.viewPager2.adapter as MainAdapter).setList(it) }

        }
    }

//    private fun recycleSetup() {
//
//        binding.rvRates.layoutManager = LinearLayoutManager(this)
//        binding.rvRates.adapter = MainAdapter()
//
//        viewModel.getRates()
//
//        viewModel.rateList.observe(this) { list ->
//
//            list.body()?.rates?.let { (binding.rvRates.adapter as MainAdapter).setList(it) }
//
//        }
//
//
//    }


}