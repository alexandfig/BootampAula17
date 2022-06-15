package com.example.useacademyretrotitclass.repository

import com.example.useacademyretrotitclass.api.LoginBody
import com.example.useacademyretrotitclass.api.LoginResponse
import com.example.useacademyretrotitclass.api.MyApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class LoginRepository {

    private var loginRoute = MyApi("https://api-desafios-usemobile.herokuapp.com").create()


    suspend fun doTheAuthentication(
        login: String,
        password:String
    ): Flow<LoginResponse>{
        return flow {
            //Faz a requisição passando o corpo da requisição
            loginRoute.doAuthentication(
                LoginBody(
                    login,
                    password
                )
            ).let { response ->
                //Response é retornado e validado
                if (response.isSuccessful){
                    response.body()
                } else {
                    throw HttpException(response)
                }
            }?.let {
                //Response é enviado
                emit(it)
            }
        }
    }


}