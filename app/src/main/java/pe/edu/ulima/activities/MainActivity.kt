package pe.edu.ulima.activities

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import pe.edu.ulima.navigations.LoginNavigation
import pe.edu.ulima.ui.login.viewmodels.CreateAccountScreenViewModel
import pe.edu.ulima.ui.login.viewmodels.LoginViewModel
import pe.edu.ulima.ui.login.viewmodels.ResetPasswordScreenViewModel
import pe.edu.ulima.ui.theme.*

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // login navigation
        var loginScreenViewModel = LoginViewModel()
        var resetPasswordScreenViewModel = ResetPasswordScreenViewModel()
        var createAccountScreenViewModel = CreateAccountScreenViewModel()
        // screen navigation
        setContent {
            ProgramMovilTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //SplashScreen()
                    LoginNavigation(
                        loginScreenViewModel = loginScreenViewModel,
                        createAccountScreenViewModel = createAccountScreenViewModel,
                        resetPasswordScreenViewModel = resetPasswordScreenViewModel,

                    )
                    //PokemonDetailScreen(viewModel = PokemonDetailViewModel())
                    //TouchScreen()
                    //Aqui abajo tambien pueden estas las navegaciones de las demas partes que tiene la aplicacion?¿
                    //Se ponen por separado ?¿
                }
            }
        }
    }
}
