package pe.edu.ulima.ui.app.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pe.edu.ulima.models.Imagen
import pe.edu.ulima.services.ImagenService
import pe.edu.ulima.services.UserService




class EditPerfilViewModel : ViewModel() {


    private val _id = MutableLiveData<Int>()
    val id: LiveData<Int> = _id

    fun updateId(it: Int) {
        _id.value = it
    }

    private val _nombre = MutableLiveData<String>()
    val nombre: LiveData<String> get() = _nombre

    fun updateNombre(it: String) {
        _nombre.value = it
    }


    private val _imagen = MutableLiveData<String>("")
    val imagen: LiveData<String> = _imagen

    fun setImagen(userId: Int) {
        _imagen.value = UserService.getImagenById(userId)
    }



    fun cargarImagenes(i: Int): List<String> {
        val imagenes: List<String> = ImagenService.fetchImageByUserId(i)
        return imagenes
    }

    private val _usuario = MutableLiveData<String>()
    val usuario: LiveData<String> get() = _usuario

    fun updateUsuario(it: String) {
        _usuario.value = it
    }

    private val _correo = MutableLiveData<String>()
    val correo: LiveData<String> = _correo

    fun updateCorreo(it: String) {
        _correo.value = it
    }

    private val _mensaje = MutableLiveData<String>()
    val mensaje: LiveData<String> = _mensaje

    fun updateMensaje(it: String) {
        _mensaje.value = it
    }

    private val _mensaje2 = MutableLiveData<String>()
    val mensaje2: LiveData<String> = _mensaje2

    fun updateMensaje2(it: String) {
        _mensaje2.value = it
    }


    private val _acontraseña = MutableLiveData<String>()
    val acontraseña: LiveData<String> = _acontraseña

    fun updateAcontraseña(it: String) {
        _acontraseña.value = it
    }

    private val _ncontraseña = MutableLiveData<String>()
    val ncontraseña: LiveData<String> = _ncontraseña

    fun updateNcontraseña(it: String) {
        _ncontraseña.value = it
    }

    private val _rcontraseña = MutableLiveData<String>()
    val rcontraseña: LiveData<String> = _rcontraseña

    fun updateRcontraseña(it: String) {
        _rcontraseña.value = it
    }


    fun editarperfil() {
        val nombre = _nombre.value
        val correo = _correo.value
        val usuario = _usuario.value

        if (nombre.isNullOrEmpty()) {
            _mensaje.value = "Error: El usuario no puede estar vacío"
            return
        }

        if (correo.isNullOrEmpty()) {
            _mensaje.value = "Error: El correo no puede estar vacío"
            return
        }

        if (usuario.isNullOrEmpty()) {
            _mensaje.value = "Error: El usuario no puede estar vacío"
            return
        }

        val nombreEnUso = UserService.verificarNombreEnUso(nombre!!)
        if (nombreEnUso) {
            _mensaje.value = "Error: El nombre ya está en uso"
            return
        }


        val correoEnUso = UserService.verificarCorreoEnUso(correo!!)
        if (correoEnUso) {
            _mensaje.value = "Error: El correo no debe coincidir"
            return
        }

        val usuarioEnUso = UserService.verificarUsuarioEnUso(usuario!!)
        if (usuarioEnUso) {
            _mensaje.value = "Error: El nombre de usuario ya existe"
            return
        }

        // Resto de la lógica para editar el perfil
        _mensaje.value = "Perfil editado exitosamente"

    }



    fun cambiarcontraseña() {
        val acontraseña = _acontraseña.value
        val ncontraseña = _ncontraseña.value
        val rcontraseña = _rcontraseña.value

        val usuarioId = UserService.validateContraseñaAntigua(acontraseña.toString()) // Lógica para obtener el id del usuario

        val contraseñaAntigua = UserService.getContraseñaAntigua(usuarioId) // Obtener la contraseña antigua del usuario desde el servicio

        if (acontraseña.isNullOrEmpty() || acontraseña != contraseñaAntigua) {
            _mensaje2.value = "Error: La contraseña antigua no es válida"
            return
        }

        if (ncontraseña.isNullOrEmpty() || rcontraseña.isNullOrEmpty() || ncontraseña != rcontraseña) {
            _mensaje2.value = "Error: Las contraseñas nuevas no coinciden"
            return
        }

        // Resto de la lógica para cambiar la contraseña
        // ...

        _mensaje2.value = "Contraseña cambiada exitosamente"
    }









}



