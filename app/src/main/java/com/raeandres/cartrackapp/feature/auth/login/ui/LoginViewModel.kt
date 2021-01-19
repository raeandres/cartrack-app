package com.raeandres.cartrackapp.feature.auth.login.ui

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.AndroidViewModel
import com.raeandres.cartrackapp.common.android.BaseViewModel
import com.raeandres.cartrackapp.common.data.persistence.CarTrackDatabase
import com.raeandres.cartrackapp.common.data.repository.UserRepository

class LoginViewModel(application: Application) : BaseViewModel(application) {

    private val loginUserRepository : UserRepository

    init {

        val userDao = CarTrackDatabase.getDatabase(application.applicationContext).userDao()

        loginUserRepository = UserRepository(userDao)
    }

    fun attemptToLogin(lifeCycleOwner: AppCompatActivity, username: String?, password: String?,
                       onSuccess: () -> Unit, onError: (String) -> Unit) {

        loginUserRepository.userLogin.observe(lifeCycleOwner, { loginData ->

            loginData?.apply {

                // validate username
                if (username == null) {
                    onError.invoke("Empty username")
                    return@observe
                }

                // validate Password
                if (password == null) {
                    onError.invoke("Empty Password")
                    return@observe
                }

                if (this.username == null) {
                    onError.invoke("No user name available")
                    return@observe
                }

                if (this.password == null) {
                    onError.invoke("No user password available")
                    return@observe
                }

                // attempt to login
                when {
                    (username == this.username && password == this.password) -> {
                        onSuccess.invoke()
                    }
                    (username != this.username) -> {
                        onError.invoke("Wrong Username")
                    }
                    (username != this.password) -> {
                        onError.invoke("Wrong Password")
                    }
                }
            } ?: onError.invoke("No user data available")

        })
    }

}