package pe.edu.ulima.ui.app.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pe.edu.ulima.models.Imagen
import pe.edu.ulima.models.Pokemon
import pe.edu.ulima.models.Usuario
import pe.edu.ulima.services.ImagenService
import pe.edu.ulima.services.PokemonService
import pe.edu.ulima.services.PublicacionService
import pe.edu.ulima.services.SeguidoService
import pe.edu.ulima.services.SeguidorService
import pe.edu.ulima.services.UserService
import java.util.Random

class HomeScreenViewModel: ViewModel() {




    private val _pokemons = mutableStateOf<List<Pokemon>?>(
        listOf()
    )
    val pokemons get() = _pokemons.value
    fun setPokemons() {
        _pokemons.value = PokemonService.fetchAll()
    }

    private val _imagen = MutableLiveData<String>("")
    val imagen: LiveData<String> = _imagen

    fun setImagen(userId: Int) {
        _imagen.value = UserService.getImagenById(userId)
    }




    private val _seguidores = MutableLiveData<Int>(
        0
    )
    val seguidores get() = _seguidores
    fun setSeguidores(userId: Int) {
        _seguidores.postValue(SeguidoService.countByUserId(userId))
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

    fun getUserNameById(userId: Int): String {
        return UserService.getUserNameById(userId)
    }






}