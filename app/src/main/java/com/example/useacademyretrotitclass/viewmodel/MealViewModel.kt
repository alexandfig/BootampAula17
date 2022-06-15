package com.example.useacademyretrotitclass.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.useacademyretrotitclass.api.MealResponse
import com.example.useacademyretrotitclass.repository.MealRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MealViewModel: ViewModel() {

    private var mealRepository = MealRepository()

    private var _mealResponse: MutableLiveData<MealResponse> = MutableLiveData()
    val mealResponse:LiveData<MealResponse> = _mealResponse

    private var _error: MutableLiveData<String> = MutableLiveData()
    val error:LiveData<String> = _error

    fun getMeals(category:String){
        viewModelScope.launch(Dispatchers.IO){
            mealRepository.getTheMeals(
                category
            ).catch { exception ->
                _error.postValue(exception.message)
            }.collect {
                _mealResponse.postValue(it)
            }
        }
    }
}