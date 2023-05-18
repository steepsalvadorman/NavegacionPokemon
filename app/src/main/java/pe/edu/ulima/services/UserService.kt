package pe.edu.ulima.services

import androidx.lifecycle.MutableLiveData
import pe.edu.ulima.models.Usuario

class UserService {
    companion object {
        var usuarios = listOf(
            Usuario (1, "admin","123", "Super Administrador", "root@ulima.edu.pe", "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/1.png"),
            Usuario (2, "pepe","123", "Pepe Valdivia", "pepe@ulima.edu.pe", "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/2.png"),
            Usuario (3, "sila","123", "Sila Esculapia", "sila@ulima.edu.pe", "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/3.png"),
            Usuario (4, "mateo","123", "Mateo Sanchez", "mateo@ulima.edu.pe", "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/4.png"),
            Usuario (5, "marcos","123", "Marcos Perez", "marcos@ulima.edu.pe", "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/5.png"),
            Usuario (6, "lucas","123", "Lucas Moura", "lucas@ulima.edu.pe", "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/6.png"),
            Usuario (7, "juan","123", "Juan Vargas", "juan@ulima.edu.pe", "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/7.png"),
            Usuario (8, "judas","123", "Judas Iscariote", "judas@ulima.edu.pe", "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/8.png"),
            Usuario (9, "tito","123", "Tito Garcia", "tito@ulima.edu.pe", "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/9.png"),
            Usuario (10, "filemon","123", "Filemon Peluche", "filemon@ulima.edu.pe", "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/9.png")
        )

        fun validate(usuario: String, contrasenia: String): Int {
            var id = 0
            for (u in usuarios) {
                if (u.usuario == usuario && u.contrasenia == contrasenia) {
                    id = u.id
                }
            }
            return id
        }

        fun validateContraseñaAntigua(contraseniaAntigua: String): Int {
            val usuario = usuarios.find { it.contrasenia == contraseniaAntigua }
            return usuario?.id ?: 0
        }

        fun fetchOne(id: Int): Usuario {
            return usuarios.find { it.id == id } ?: Usuario()
        }

        fun getUserNameById(id: Int): String {
            return usuarios.find { it.id == id }?.nombre ?: ""
        }

        fun verificarNombreEnUso(nombre: String): Boolean {
            return usuarios.any { it.nombre == nombre }
        }

        fun verificarUsuarioEnUso(usuario: String): Boolean {
            return usuarios.any { it.usuario == usuario }
        }

        fun verificarCorreoEnUso(correo: String): Boolean {
            return usuarios.any { it.correo == correo }
        }

        fun getContraseñaAntigua(id: Int): String {
            val usuario = usuarios.find { it.id == id }
            return usuario?.contrasenia ?: ""
        }

        fun getImagenById(id: Int): String {
            return usuarios.find { it.id == id }?.imagen ?: ""
        }


    }
}



