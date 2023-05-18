package pe.edu.ulima.services

import pe.edu.ulima.models.Seguido
import pe.edu.ulima.models.Seguidor

class SeguidoService {
    companion object {
        fun fetchAll(): List<Seguido> {
            return listOf(
                Seguido (1,1,2,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/50.png"),
                Seguido (2,1,3,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/51.png"),
                Seguido (3,1,4,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/52.png"),
                Seguido (4,1,5,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/53.png"),
                Seguido (5,1,6,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/54.png"),
                Seguido (6,1,7,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/55.png"),
                Seguido (7,2,1,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/56.png"),
                Seguido (8,2,4,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/57.png"),
                Seguido (9,2,5,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/58.png"),
                Seguido (10,2,6,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/59.png"),
                Seguido (11,2,7,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/60.png"),
                Seguido (12,3,1,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/61.png"),
                Seguido (13,3,2,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/62.png"),
                Seguido (14,3,4,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/63.png"),
                Seguido (15,3,10,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/64.png"),
                Seguido (16,4,8,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/16.png"),
                Seguido (17,4,9,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/17.png"),
                Seguido (18,4,10,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/18.png"),
                Seguido (19,4,1,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/19.png"),
                Seguido (20,5,1,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/20.png"),
                Seguido (21,5,2,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/21.png"),
                Seguido (22,5,3,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/22.png"),
                Seguido (23,5,4,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/23.png"),
                Seguido (24,5,6,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/24.png"),
                Seguido (25,5,7,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/25.png"),
                Seguido (26,5,8,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/26.png"),
                Seguido (27,5,9,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/27.png"),
                Seguido (28,5,10,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/28.png"),
                Seguido (29,6,1,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/29.png"),
                Seguido (30,6,7,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/30.png"),
                Seguido (31,6,3,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/31.png"),
                Seguido (32,6,10,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/32.png"),
                Seguido (33,7,1,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/33.png"),
                Seguido (34,7,3,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/34.png"),
                Seguido (35,7,6,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/35.png"),
                Seguido (36,7,8,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/36.png"),
                Seguido (37,7,9,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/37.png"),
                Seguido (38,8,1,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/38.png"),
                Seguido (39,8,2,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/39.png"),
                Seguido (40,8,3,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/40.png"),
                Seguido (41,8,4,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/41.png"),
                Seguido (42,9,5,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/42.png"),
                Seguido (43,9,6,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/43.png"),
                Seguido (44,10,1,"https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/44.png"),
            )
        }
        fun countByUserId(userId: Int): Int {
            val list: List<Seguido> = fetchAll()
            return list.count { it.seguidoId == userId }
        }

    }
}