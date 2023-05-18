package pe.edu.ulima.services

import pe.edu.ulima.models.Imagen
import pe.edu.ulima.models.Seguido
import pe.edu.ulima.models.Seguidor
import pe.edu.ulima.models.Usuario

class SeguidorService {
    companion object {
        fun fetchAll(): List<Seguidor> {
            return listOf(
                Seguidor (1,1,2,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/1.png"),
                Seguidor (2,1,3,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/2.png"),
                Seguidor (3,1,4,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/3.png"),
                Seguidor (4,1,5,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/4.png"),
                Seguidor (5,1,6,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/5.png"),
                Seguidor (6,1,7,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/6.png"),
                Seguidor (7,2,1,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/7.png"),
                Seguidor (8,2,4,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/8.png"),
                Seguidor (9,2,5,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/9.png"),
                Seguidor (10,2,6,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/10.png"),
                Seguidor (11,2,7,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/11.png"),
                Seguidor (12,3,1,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/12.png"),
                Seguidor (13,3,2,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/13.png"),
                Seguidor (14,3,4,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/14.png"),
                Seguidor (15,3,10,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/15.png"),
                Seguidor (16,4,8,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/16.png"),
                Seguidor (17,4,9,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/17.png"),
                Seguidor (18,4,10,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/18.png"),
                Seguidor (19,4,1,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/19.png"),
                Seguidor (20,5,1,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/20.png"),
                Seguidor (21,5,2,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/21.png"),
                Seguidor (22,5,3,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/22.png"),
                Seguidor (23,5,4,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/23.png"),
                Seguidor (24,5,6,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/24.png"),
                Seguidor (25,5,7,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/25.png"),
                Seguidor (26,5,8,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/26.png"),
                Seguidor (27,5,9,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/27.png"),
                Seguidor (28,5,10,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/28.png"),
                Seguidor (29,6,1,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/29.png"),
                Seguidor (30,6,7,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/30.png"),
                Seguidor (31,6,3,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/31.png"),
                Seguidor (32,6,10,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/32.png"),
                Seguidor (33,7,1,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/33.png"),
                Seguidor (34,7,3,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/34.png"),
                Seguidor (35,7,6,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/35.png"),
                Seguidor (36,7,8,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/36.png"),
                Seguidor (37,7,9,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/37.png"),
                Seguidor (38,8,1,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/38.png"),
                Seguidor (39,8,2,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/39.png"),
                Seguidor (40,8,3,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/40.png"),
                Seguidor (41,8,4,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/41.png"),
                Seguidor (42,9,5,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/42.png"),
                Seguidor (43,9,6,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/43.png"),
                Seguidor (44,10,1,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/44.png"),
            )
        }

        fun countByUserId(userId: Int): Int {
            val list: List<Seguidor> = SeguidorService.fetchAll()
            return list.count { it.seguidorId == userId }
        }

    }
}