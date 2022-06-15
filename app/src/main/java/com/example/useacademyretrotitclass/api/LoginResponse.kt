package com.example.useacademyretrotitclass.api

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("user_info")
    val userInfo: UserInfo,
    @SerializedName("user_credentials")
    val userCredentials: UserCredentials,
    @SerializedName("has_notifications")
    val hasNotifications: Boolean
)



data class UserInfo(
    @SerializedName("user_name")
    val userName: String,
    @SerializedName("account_code")
    val accountCode: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("use_coins")
    val useCoins: Int,
    @SerializedName("photo")
    val photo: String
)

data class UserCredentials(
    @SerializedName("login")
    val login:String,
    @SerializedName("password")
    val password:String
)


/*
*
*  "email": "jobs@usemobile.com.br",  String
  "use_coins": 10000,  Int
   "photo": null  String
*
*
* "user_credentials": {
  "login": "usemobile",  String
  "password": "3325da827da07f5b65722300a45cd8257ee8b055d54d365aa87a371db358ab21"  String
},
 "has_notifications": false  Boolean
*
*
*
* */