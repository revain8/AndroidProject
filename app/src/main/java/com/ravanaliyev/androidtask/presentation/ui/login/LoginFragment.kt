package com.ravanaliyev.androidtask.presentation.ui.login

import android.widget.Toast
import com.ravanaliyev.androidtask.common.BaseFragment
import com.ravanaliyev.androidtask.databinding.FragmentLoginBinding
import com.ravanaliyev.androidtask.utils.CredentialsManager

class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    private val credentialsManager = CredentialsManager()
    override fun onViewCreateFinish() {
        setup()
    }

    private fun setup() {
        with(binding) {
            buttonRegister.setOnClickListener {
                navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment())
            }
            buttonLogin.setOnClickListener {
                login()
            }
        }
    }

    private fun login() {
        with(binding) {
            val email = etEmail.text.toString()
            val pass = etPassword.text.toString()

            val loginCredentials = listOf(
                credentialsManager.validateEmail(email),
                credentialsManager.validatePassword(pass)
            )

            val hasError = loginCredentials.any { !it.isSuccess }

            if (hasError) {
                Toast.makeText(
                    requireContext(),
                    loginCredentials.first { it.isSuccess.not() }.errorMessage.orEmpty(),
                    android.widget.Toast.LENGTH_LONG
                ).show()
                return
            }
            Toast.makeText(requireContext(), "Welcome.", android.widget.Toast.LENGTH_LONG).show()
            navigate(LoginFragmentDirections.actionLoginFragmentToHomeFragment())

        }

    }


}
