package pe.edu.ulima.ui.login.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pe.edu.ulima.services.UserService

class ResetPasswordScreenViewModel: ViewModel() {
    private val _correo = MutableLiveData<String>("")
    var correo: LiveData<String> = _correo
    fun updateCorreo(it: String){
        _correo.postValue(it)
    }

    private val _mensaje = MutableLiveData<String>("")
    var mensaje: LiveData<String> = _mensaje
    fun updateMensaje(it: String){
        _mensaje.postValue(it)
    }

    fun reset() {
        val emailRegex = "^[\\w\\.-]+@[\\w\\.-]+\\.[\\w-]{2,}$".toRegex()
        val email = correo.value?.trim()

        // Verificar si el campo de correo está lleno
        if (email.isNullOrEmpty()) {
            updateMensaje("Error: Por favor ingrese un correo electrónico.")
            return
        }

        // Verificar si el correo cumple con el formato de un correo electrónico
        if (!email.matches(emailRegex)) {
            updateMensaje("Error: El correo electrónico ingresado no es válido.")
            return
        }

        // Verificar si el correo está registrado
        val isRegistered = checkIfEmailIsRegistered(email)
        if (!isRegistered) {
            updateMensaje("Error: El correo electrónico no está registrado.")
            return
        }

        // Si llegamos hasta aquí, el correo es válido y está registrado
        // Aquí iría el código para enviar el correo de reseteo de contraseña
        // ...
        updateMensaje("Se ha enviado un correo electrónico con las instrucciones para resetear la contraseña.")
    }

    fun checkIfEmailIsRegistered(email: String): Boolean {
        for (u in UserService.usuarios) {
            if (u.correo == email) {
                return true
            }
        }
        return false
    }


}