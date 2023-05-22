package pe.edu.ulima.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import pe.edu.ulima.ui.app.uis.EditPerfilScreen
import pe.edu.ulima.ui.app.uis.FollowerScreen
import pe.edu.ulima.ui.app.uis.HomeFollowsScreen
import pe.edu.ulima.ui.app.uis.HomeScreen
import pe.edu.ulima.ui.app.viewmodels.EditPerfilViewModel
import pe.edu.ulima.ui.app.viewmodels.FollowerScreenViewModel
import pe.edu.ulima.ui.app.viewmodels.HomeScreenViewModel
import pe.edu.ulima.ui.app.viewmodels.PokemonViewModel

@Composable
fun AppNavigation(
    editPerfilViewModel: EditPerfilViewModel,
    homeScreenViewModel: HomeScreenViewModel,
    pokemonViewModel: PokemonViewModel,
    followerScreenViewModel: FollowerScreenViewModel
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "/pokemon"
    ) {
        // Vista para mostrar el listado de pokemones
        composable(route = "/pokemon") {
            HomeScreen(
                goToEditPerfilScreen = {
                    navController.navigate("/pokemon/edit_perfil")
                },
                goToFollowsScreen = {
                    navController.navigate("/pokemon/seguidos")
                },
                homeScreenViewModel

            )
        }

        composable(route = "/pokemon/edit_perfil") { entry ->
            EditPerfilScreen(
                editPerfilViewModel
            )
        }

        composable(
            route = "/pokemon/seguidos"
        ) { entry ->
            HomeFollowsScreen(
                pokemonViewModel
            ) { followerId ->
                navController.navigate("/pokemon/seguidos/seguidor/$followerId")
            }
        }


        composable(
            route = "/pokemon/seguidos/seguidor/{followerId}",
            arguments = listOf(
                navArgument("followerId") { type = NavType.IntType }
            )
        ) { entry ->
            val followerId = entry.arguments?.getInt("followerId")
            FollowerScreen(
                viewModel = followerScreenViewModel,
                followerId = followerId ?: 0
            )
        }

    }
}
