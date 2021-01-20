package com.raeandres.cartrackapp.feature.auth.login.ui

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import com.raeandres.cartrackapp.common.android.BaseViewModel
import com.raeandres.cartrackapp.common.data.real.persistence.CarTrackDatabase
import com.raeandres.cartrackapp.common.data.real.repository.CarTrackRepository

class LoginViewModel(application: Application, repository: CarTrackRepository) : BaseViewModel(application, repository) {

    fun attemptToLogin(lifeCycleOwner: AppCompatActivity, username: String?, password: String?,
                       onSuccess: () -> Unit, onError: (String) -> Unit) {

        carTrackRepository.login.observe(lifeCycleOwner, { loginData ->

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
                    (username.toString() == this.username && password.toString() == this.password) -> {
                        onSuccess.invoke()
                        return@observe
                    }
                    (username != this.username) -> {
                        onError.invoke("Wrong Username")
                        return@observe
                    }
                    (username != this.password) -> {
                        onError.invoke("Wrong Password")
                        return@observe
                    }
                }
            } ?: onError.invoke("No user data available")

        })
    }

}