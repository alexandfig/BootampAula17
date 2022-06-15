package com.example.useacademyretrotitclass.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.useacademyretrotitclass.api.LoginResponse
import com.example.useacademyretrotitclass.repository.LoginRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {

    val repository: LoginRepository = LoginRepository()

    private val _loginSuccess: MutableLiveData<LoginResponse> = MutableLiveData()
    val loginSuccess: LiveData<LoginResponse> = _loginSuccess

    private val _error: MutableLiveData<String> = MutableLiveData()
    val error: LiveData<String> = _error

    fun authenticate(login: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.doTheAuthentication(
                login,
                password
            ).catch { exception ->
                _error.postValue(exception.message)
            }.collect { loginResponse ->
                _loginSuccess.postValue(loginResponse)
            }
        }
    }
}