package com.raeandres.cartrackapp.common.utilities

import com.raeandres.cartrackapp.common.data.FakeDatabase
import com.raeandres.cartrackapp.common.data.FakeLoginDao
import com.raeandres.cartrackapp.common.data.UserRepository
import com.raeandres.cartrackapp.feature.auth.login.model.LoginVmFactory

object InjectorUtils {

    fun provideLoginVmFactory() : LoginVmFactory {
        val loginRepository = UserRepository.getInstance(FakeDatabase.getInstance().loginDao)
        return LoginVmFactory(loginRepository)
    }
}