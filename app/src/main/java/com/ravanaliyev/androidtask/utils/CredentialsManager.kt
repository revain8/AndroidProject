package com.ravanaliyev.androidtask.utils

import android.util.Patterns

class CredentialsManager {

    fun validateEmail(email: String): CredentialsResult {
        if (email.isEmpty()) {
            return CredentialsResult(
                isSuccess = false,
                errorMessage = "Email is empty."
            )
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return CredentialsResult(
                isSuccess = false,
                errorMessage = "Enter valid email."
            )
        }
        if (email != "test@te.st") {
            return CredentialsResult(
                isSuccess = false,
                errorMessage = "Wrong email."
            )
        }
        return CredentialsResult(isSuccess = true)
    }

    fun validatePassword(password: String): CredentialsResult {
        if (password.isEmpty()) {
            return CredentialsResult(
                isSuccess = false,
                errorMessage = "Password is empty."
            )
        }
        if (password != "1234") {
            return CredentialsResult(
                isSuccess = false,
                errorMessage = "Password is wrong."
            )
        }
        return CredentialsResult(isSuccess = true)
    }

}

data class CredentialsResult(
    val isSuccess : Boolean,
    val errorMessage : String? = null
)