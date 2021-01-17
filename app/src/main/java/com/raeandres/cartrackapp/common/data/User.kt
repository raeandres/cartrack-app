package com.raeandres.cartrackapp.common.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


sealed class User{

}

data class UserInfo(val firstName: String, val lastName: String, val email: String? = null) : User()
data class Login(var userName: String? = null, var password: String? = null) : User()


class FakeLoginDao {
    private val login = Login()

    private val liveDataLogin = MutableLiveData<Login>()

    init {
        liveDataLogin.value = login
    }

    fun loginUser(userLogin: Login) {
        login.userName = userLogin.userName
        login.password = userLogin.password
    }

    fun getLogin() = login as LiveData<Login>
}