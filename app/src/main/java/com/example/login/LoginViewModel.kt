package com.example.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf


class LoginViewModel {
    private var _username = mutableStateOf<String>("")
    val username: State<String> = _username

    private var _confirmUsername = mutableStateOf<String>("")
    val confirmUsername: State<String> = _confirmUsername

    private var _password = mutableStateOf<String>("")
    val password: State<String> = _password

    private var _confirmPassword = mutableStateOf<String>("")
    val confirmPassword: State<String> = _confirmPassword

    private var _isChecked = mutableStateOf<Boolean>(false)
    var isChecked: State<Boolean> = _isChecked

    private var _passwordVisibility = mutableStateOf<Boolean>(false)
    val passwordVisibility: State<Boolean> = _passwordVisibility

    private var _passwordConfirmVisibility = mutableStateOf<Boolean>(false)
    val passwordConfirmVisibility: State<Boolean> = _passwordConfirmVisibility

    private var _isLoggedIn = mutableStateOf<Boolean>(false)
    val isLoggedIn: State<Boolean> = _isLoggedIn

    fun onUsernameChanged(newUsername: String) {
        _username.value = newUsername
    }

    fun onConfirmUsernameChanged(newUsername: String) {
        _confirmUsername.value = newUsername
    }

    fun onPasswordChanged(newPassword: String) {
        _password.value = newPassword
    }

    fun onConfirmPasswordChanged(newPassword: String) {
        _confirmPassword.value = newPassword
    }

    fun togglePasswordVisibility() {
        _passwordVisibility.value = !_passwordVisibility.value
    }

    fun toggleConfirmPasswordVisibility() {
        _passwordConfirmVisibility.value = !_passwordConfirmVisibility.value
    }

    fun toggleIsChecked() {
        _isChecked.value = !_isChecked.value
    }


    fun login() {
        // Lógica para iniciar sesión
        if (_username.value.isNotEmpty() && _password.value.isNotEmpty()) {
            _isLoggedIn.value = true
        }
    }

    fun logout() {
        _isLoggedIn.value = false
    }
}
