package com.example.login
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    // Estado para el nombre de usuario
    private val _username = mutableStateOf("")
    val username: State<String> get() = _username

    // Estado para la contraseña
    private val _password = mutableStateOf("")
    val password: State<String> get() = _password

    // Estado para saber si la contraseña es visible
    private val _passwordVisibility = mutableStateOf(false)
    val passwordVisibility: State<Boolean> get() = _passwordVisibility

    // Estado para determinar si el usuario ha iniciado sesión
    private val _isLoggedIn = mutableStateOf(false)
    val isLoggedIn: State<Boolean> get() = _isLoggedIn

    // Actualizar el nombre de usuario
    fun onUsernameChanged(newUsername: String) {
        _username.value = newUsername
    }

    // Actualizar la contraseña
    fun onPasswordChanged(newPassword: String) {
        _password.value = newPassword
    }

    // Alternar la visibilidad de la contraseña
    fun togglePasswordVisibility() {
        _passwordVisibility.value = !_passwordVisibility.value
    }

    // Simular inicio de sesión
    fun login() {
        if (_username.value.isNotBlank() && _password.value.isNotBlank()) {
            _isLoggedIn.value = true
        }
    }

    // Cerrar sesión
    fun logout() {
        _isLoggedIn.value = false
        _username.value = ""
        _password.value = ""
    }
}
