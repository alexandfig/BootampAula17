package com.example.useacademyretrotitclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.example.useacademyretrotitclass.databinding.ActivityMealBinding
import com.example.useacademyretrotitclass.viewmodel.MealViewModel

class MealActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMealBinding
    private lateinit var viewModel: MealViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMealBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MealViewModel::class.java)
        viewModel.getMeals("Seafood")
        onObserve()

    }

    private fun onObserve(){
        viewModel.apply {
            mealResponse.observe(this@MealActivity, Observer { mealResponse ->
                binding.textViewMealName.text = mealResponse.meals[0].mealName
                binding.imageViewMealImage.load(mealResponse.meals[0].strMealThumb)
            })
        }
    }
}