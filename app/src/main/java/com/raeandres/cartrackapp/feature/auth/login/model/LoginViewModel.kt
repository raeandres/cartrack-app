package com.raeandres.cartrackapp.feature.auth.login.model

import androidx.lifecycle.ViewModel
import com.raeandres.cartrackapp.common.data.UserRepository

class LoginViewModel(private val userRepository: UserRepository) : ViewModel() {

   fun getUserLogin() = userRepository.getLoginCredentials()


}