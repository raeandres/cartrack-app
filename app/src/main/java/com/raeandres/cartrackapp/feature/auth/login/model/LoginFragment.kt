package com.raeandres.cartrackapp.feature.auth.login.model

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.raeandres.cartrackapp.R
import com.raeandres.cartrackapp.common.android.BaseFragment
import com.raeandres.cartrackapp.feature.auth.login.ui.LoginViewModel

class LoginFragment : BaseFragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle? ): View? {
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        return inflater.inflate(R.layout.login_fragment, container, false)
    }


}