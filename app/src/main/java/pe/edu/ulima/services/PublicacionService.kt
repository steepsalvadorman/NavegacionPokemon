package pe.edu.ulima.services

import pe.edu.ulima.models.Imagen
import pe.edu.ulima.models.Publicaciones
import pe.edu.ulima.models.Seguidor

class PublicacionService {
    companion object {
        fun fetchAll(): List<Publicaciones> {
            return listOf(
                Publicaciones (1,1,2),
                Publicaciones (2,1,3),
                Publicaciones (3,1,4),
                Publicaciones (4,1,5),
                Publicaciones (5,1,6),
                Publicaciones (6,1,7),
                Publicaciones (7,2,1),
                Publicaciones (8,2,4),
                Publicaciones (9,2,5),
                Publicaciones (10,2,6),
                Publicaciones (11,2,7),
                Publicaciones (12,3,1),
                Publicaciones (13,3,2),
                Publicaciones (14,3,4),
                Publicaciones (15,3,10),
                Publicaciones (16,4,8),
                Publicaciones (17,4,9),
                Publicaciones (18,4,10),
                Publicaciones (19,4,1),
                Publicaciones (20,5,1),
                Publicaciones (21,5,2),
                Publicaciones (22,5,3),
                Publicaciones (23,5,4),
                Publicaciones (24,5,6),
                Publicaciones (25,5,7),
                Publicaciones (26,5,8),
                Publicaciones (27,5,9),
                Publicaciones (28,5,10),
                Publicaciones (29,6,1),
                Publicaciones (30,6,7),
                Publicaciones (31,6,3),
                Publicaciones (32,6,10),
                Publicaciones (33,7,1),
                Publicaciones (34,7,3),
                Publicaciones (35,7,6),
                Publicaciones (36,7,8),
                Publicaciones (37,7,9),
                Publicaciones (38,8,1),
                Publicaciones (39,8,2),
                Publicaciones (40,8,3),
                Publicaciones (41,8,4),
                Publicaciones (42,9,5),
                Publicaciones (43,9,6),
                Publicaciones (44,10,1),
            )
        }

        fun countByUserId(userId: Int): Int{
            var respuesta : Int = 0
            val list: List<Publicaciones> = PublicacionService.fetchAll()
            for(publicacion in list){
                if(publicacion.usuarioId == userId){
                    respuesta = respuesta + 1
                }
            }
            return respuesta
        }
    }
}