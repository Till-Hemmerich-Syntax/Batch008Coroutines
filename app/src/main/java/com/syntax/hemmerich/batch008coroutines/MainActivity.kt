package com.syntax.hemmerich.batch008coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.syntax.hemmerich.batch008coroutines.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addObserver()

        binding.fbtnHome.setOnClickListener {
            viewModel.loadNewImage()
        }

    }


    fun addObserver(){
        viewModel.loading.observe(this){
            if(it){
                binding.spinner.visibility = View.VISIBLE
            }else{
                binding.spinner.visibility = View.GONE
            }
        }
        viewModel.image.observe(this){
            binding.imageText.text = it
        }
    }
}