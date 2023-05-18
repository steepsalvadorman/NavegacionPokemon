package pe.edu.ulima.ui.app.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pe.edu.ulima.models.Imagen
import pe.edu.ulima.services.ImagenService
import pe.edu.ulima.services.PublicacionService
import pe.edu.ulima.services.SeguidoService
import pe.edu.ulima.services.SeguidorService
import pe.edu.ulima.services.UserService

class FollowerScreenViewModel: ViewModel() {




    fun imagen(id: Int): List<Imagen> {
        var imagen = ImagenService.fetchByUserId(id)

        return imagen
    }

    fun getUserNameById(userId: Int): String {
        return UserService.getUserNameById(userId)
    }


    private val _seguidores = MutableLiveData<Int>(
        0
    )
    val seguidores get() = _seguidores
    fun setSeguidores(userId: Int) {
        _seguidores.postValue(SeguidorService.countByUserId(userId))
    }

    private val _seguidos = MutableLiveData<Int>(
        0
    )
    val seguidos get() = _seguidos
    fun setSeguidos(userId: Int) {
        _seguidos.postValue(SeguidoService.countByUserId(userId))
    }

    private val _publicaciones = MutableLiveData<Int>(
        0
    )
    val publicaciones get() = _publicaciones
    fun setPublicaciones(userId: Int) {
        _publicaciones.postValue(PublicacionService.countByUserId(userId))
    }

    fun getPublicaciones(followerId: Int): Int {
        var publicaciones = PublicacionService.countByUserId(followerId)

        return publicaciones
    }

}