package pe.edu.ulima.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import pe.edu.ulima.activities.ui.theme.ProgramMovilTheme
import pe.edu.ulima.navigations.AppNavigation
import pe.edu.ulima.ui.app.viewmodels.EditPerfilViewModel
import pe.edu.ulima.ui.app.viewmodels.FollowerScreenViewModel
import pe.edu.ulima.ui.app.viewmodels.HomeScreenViewModel
import pe.edu.ulima.ui.app.viewmodels.PokemonViewModel
import pe.edu.ulima.ui.login.viewmodels.LoginViewModel

class AppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val editPerfilViewModel = EditPerfilViewModel()
        val homeScreenViewModel = HomeScreenViewModel()
        val pokemonViewModel = PokemonViewModel()
        val followerScreenViewModel = FollowerScreenViewModel()
        setContent {
            ProgramMovilTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AppNavigation(
                        editPerfilViewModel= editPerfilViewModel,
                        homeScreenViewModel= homeScreenViewModel,
                        pokemonViewModel= pokemonViewModel,
                        followerScreenViewModel = followerScreenViewModel

                    )
                }
            }
        }
    }
}
