package pe.edu.ulima.ui.login.viewmodels

import android.content.Context
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pe.edu.ulima.models.Usuario
import pe.edu.ulima.services.UserService

class CreateAccountScreenViewModel : ViewModel() {
    private val _usuario = MutableLiveData<String>("")
    var usuario: LiveData<String> = _usuario

    private val _correo = MutableLiveData<String>("")
    var correo: LiveData<String> = _correo

    private val _contrasenia = MutableLiveData<String>("")
    var contrasenia: LiveData<String> = _contrasenia

    private val _repcontrasenia = MutableLiveData<String>("")
    var repcontrasenia: LiveData<String> = _repcontrasenia

    private val _mensaje = MutableLiveData<String>("")
    var mensaje: LiveData<String> = _mensaje

    fun updateUsuario(it: String) {
        _usuario.postValue(it)
    }

    fun updateCorreo(it: String) {
        _correo.postValue(it)
    }

    fun updateContrasenia(it: String) {
        _contrasenia.postValue(it)
    }

    fun updateRepContrasenia(it: String) {
        _repcontrasenia.postValue(it)
    }
    fun updateMensaje(it: String){
        _mensaje.postValue(it)
    }

    fun crear(context: Context) {
        // Obtener los valores ingresados por el usuario
        val usuario = _usuario.value
        val correo = _correo.value
        val contrasenia = _contrasenia.value
        val repContrasenia = _repcontrasenia.value

        // Verificar que todos los campos estén llenos
        if (usuario.isNullOrEmpty() || correo.isNullOrEmpty() || contrasenia.isNullOrEmpty() || repContrasenia.isNullOrEmpty()) {
            updateMensaje("Error: Por favor, complete todos los campos")
            return
        }

        // Verificar que el correo tenga un formato válido
        if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
            updateMensaje("Error: Ingrese un correo electrónico válido")
            return
        }

        // Verificar que las contraseñas sean iguales
        if (contrasenia != repContrasenia) {
            updateMensaje("Error: Las contraseñas no coinciden")
            return
        }

        // Verificar que el usuario y correo no estén repetidos
        if (UserService.usuarios.any { it.usuario == usuario || it.correo == correo }) {
            updateMensaje("Error: El usuario o correo ya están en uso")
            return
        }

        // Crear el nuevo usuario y agregarlo a la lista de usuarios
        val nuevoUsuario = Usuario(
            id = UserService.usuarios.size + 1,
            usuario = usuario,
            contrasenia = contrasenia,
            nombre = "",
            correo = correo,
            imagen = "",
        )
        UserService.usuarios += nuevoUsuario

        // Establecer mensaje de éxito
        updateMensaje("Cuenta creada exitosamente")
    }

}
