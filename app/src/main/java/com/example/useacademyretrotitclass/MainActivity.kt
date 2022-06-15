package com.example.useacademyretrotitclass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.useacademyretrotitclass.databinding.ActivityMainBinding
import com.example.useacademyretrotitclass.viewmodel.LoginViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        onClick()
        onObserve()
    }

    private fun onClick(){
        binding.apply {
            buttonLogin.setOnClickListener {
                viewModel.authenticate(
                    editTextUserName.text.toString(),
                    editTextUserPassword.text.toString()
                )
            }
        }
    }

    private fun onObserve(){
        viewModel.apply {
            loginSuccess.observe(this@MainActivity, Observer {
                Toast.makeText(
                    this@MainActivity,
                    " Bem-vindo ${it.userInfo.userName}",
                    Toast.LENGTH_LONG
                ).show()
                val intent = Intent(this@MainActivity, MealActivity::class.java)
                startActivity(intent)
            })
            error.observe(this@MainActivity, Observer {
                Toast.makeText(
                    this@MainActivity,
                    it,
                    Toast.LENGTH_LONG
                ).show()
            })
        }
    }
}

/*
*
*
*  App ---> Servidor
*
* Api é uma url.
*
* Toda api ela vai ser composta por uma URl ( url base).
*
* Toda url pode ser juntada com endpoints.
*
*Para cada endpoint, um tipo de dado é baixado pro app.
*
* App ----> Servidor ---> JSON ( vai ser moldado na forma de classe)
*
*
*
* */