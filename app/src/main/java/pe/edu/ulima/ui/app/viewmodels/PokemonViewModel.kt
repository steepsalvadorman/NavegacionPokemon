package pe.edu.ulima.ui.app.viewmodels

import android.content.Context
import android.content.Intent
import android.os.Handler
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pe.edu.ulima.activities.AppActivity
import pe.edu.ulima.models.Imagen
import pe.edu.ulima.models.Pokemon
import pe.edu.ulima.models.Seguido
import pe.edu.ulima.models.Seguidor
import pe.edu.ulima.services.ImagenService
import pe.edu.ulima.services.PokemonService
import pe.edu.ulima.services.SeguidoService
import pe.edu.ulima.services.SeguidorService
import pe.edu.ulima.services.SeguidorService.Companion.fetchAll
import pe.edu.ulima.services.UserService

class PokemonViewModel: ViewModel(){
    private val _pokemons = mutableStateOf<List<Pokemon>?>(
        listOf()
    )
    val pokemons get() = _pokemons.value
    fun setPokemons() {
        _pokemons.value = PokemonService.fetchAll()
    }

    private val _imagenes = mutableStateOf<List<Imagen>?>(
        listOf()
    )
    val imagenes get() = _imagenes.value
    fun setImagenes(userId: Int) {
        _imagenes.value = ImagenService.fetchByUserId(userId)
    }

    private val _selectedId = mutableStateOf<Int?>(
        null
    )
    val selectedId get() = _selectedId.value
    fun setSelectedId(selectedId: Int) {
        _selectedId.value = selectedId
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

    private val _mensaje = MutableLiveData<String>()
    val mensaje: LiveData<String> = _mensaje

    fun updateMensaje(it: String) {
        _mensaje.value = it
    }

    private val _usuario = MutableLiveData<String>()
    val usuario: LiveData<String> get() = _usuario

    fun updateUsuario(it: String) {
        _usuario.value = it
    }

    private val _contrasenia = MutableLiveData<String>()
    val contrasenia: LiveData<String> get() = _contrasenia

    fun updateContrasenia(it: String) {
        _contrasenia.value = it
    }

    fun getSeguidores(userId: Int): List<Seguidor> {
        val list: List<Seguidor> =  SeguidorService.fetchAll()
        return list.filter { it.seguidorId == userId }
    }

    fun getSeguidos(userId: Int): List<Seguido> {
        val list: List<Seguido> = SeguidoService.fetchAll()
        return list.filter { it.seguidoId == userId }
    }




}