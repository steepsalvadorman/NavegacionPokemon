package pe.edu.ulima.navigations

import android.content.Intent
import android.os.Handler
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import pe.edu.ulima.activities.AppActivity
import pe.edu.ulima.ui.login.uis.CreateAccountScreen
import pe.edu.ulima.ui.login.uis.LoginScreen
import pe.edu.ulima.ui.login.uis.ResetPasswordScreen
import pe.edu.ulima.ui.login.uis.SplashScreen
import pe.edu.ulima.ui.login.viewmodels.CreateAccountScreenViewModel
import pe.edu.ulima.ui.login.viewmodels.LoginViewModel
import pe.edu.ulima.ui.login.viewmodels.ResetPasswordScreenViewModel

@Composable
fun LoginNavigation(
    loginScreenViewModel: LoginViewModel,
    resetPasswordScreenViewModel: ResetPasswordScreenViewModel,
    createAccountScreenViewModel: CreateAccountScreenViewModel,
){
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val parameter = navBackStackEntry?.arguments?.getString("parameter")
    val optionalParameter = navBackStackEntry?.arguments?.getString("optionalParameter")

    NavHost(
        navController = navController,
        startDestination = "/"
    ){
        composable(
            route = "/",
            arguments = listOf()
        ){ entry ->
            SplashScreen()
            Handler().postDelayed({
                navController.navigate("/login/") //Despues de 2 segundos vamos a /login/
            }, 2000)

        }


        composable(
            route = "/login/",
            arguments = listOf()
        ){ entry ->
            LoginScreen(
                loginScreenViewModel,
                goToCreateAccountScreen = {
                    navController.navigate("/create_account")
                },
                goToResetPasswordScreen = {
                    navController.navigate("/reset_password")
                }
            )
        }




        composable(
            route = "/login/{parameter}?optionalParameter={optionalParameter}",
            arguments = listOf(
                navArgument("parameter") {
                    type = NavType.StringType
                    defaultValue = ""
                },
                navArgument("optionalParameter") {
                    type = NavType.StringType
                    defaultValue = "default_value"
                }
            )
        ){ entry ->
            Log.d("pe.edu.ulima", "1 +++++++++++++++++++++++++++++++++++++++++++")
            Log.d("pe.edu.ulima", parameter.toString())
            Log.d("pe.edu.ulima", optionalParameter.toString())
            Log.d("pe.edu.ulima", "2 +++++++++++++++++++++++++++++++++++++++++++")
            if(parameter == null || parameter == ""){
                LoginScreen(
                    loginScreenViewModel,
                    goToCreateAccountScreen = {
                        navController.navigate("/create_account")
                    },
                    goToResetPasswordScreen = {
                    navController.navigate("/reset_password")
                    },

                )
                //que hace esto redirige hacia reset password si no tiene los parametros?¿ ¿parameter?
            }else{
                loginScreenViewModel.updateUsuario(parameter)
                LoginScreen(
                    loginScreenViewModel,
                    goToCreateAccountScreen = {
                        navController.navigate("/create_account")
                    },
                    goToResetPasswordScreen = {
                        navController.navigate("/reset_password")
                    }
                )
            }
        }

        composable(
            route = "/reset_password",
            arguments = listOf()
        ){ entry ->
            ResetPasswordScreen(
                resetPasswordScreenViewModel,
                goToLoginScreen = {
                    val parameter = resetPasswordScreenViewModel.correo.value.toString()
                    navController.navigate("/login/$parameter")
                    //ESTO TAMPOCO ENTIENDO
                }
            )
        }

        composable(
            route = "/create_account",
            arguments = listOf()
        ){ entry ->
            CreateAccountScreen(
                createAccountScreenViewModel,
                goToLoginScreen={
                    val parameter = resetPasswordScreenViewModel.correo.value.toString()
                    navController.navigate("/login/$parameter")
                },
                goToResetPasswordScreen = {
                    navController.navigate("/reset_password")
                }



            )

        }


    }
}
