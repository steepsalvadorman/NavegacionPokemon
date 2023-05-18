package pe.edu.ulima.ui.app.uis

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import pe.edu.ulima.models.Seguido
import pe.edu.ulima.models.Seguidor
import pe.edu.ulima.services.UserService
import pe.edu.ulima.ui.app.viewmodels.PokemonViewModel


@Preview
@Composable
fun HomeFollowsScreenPreview(){
    HomeFollowsScreen(
        PokemonViewModel(),
    ) {}
}

@Composable
fun HomeFollowsScreen(
    viewModel: PokemonViewModel,
    goToFollowerScreen: (Any?) -> Unit,
) {
    val context = LocalContext.current
    val activity = context as Activity
    val intent = activity.intent
    val userId = intent.getIntExtra("user_id", 0)
    val seguidores: Int by viewModel.seguidores.observeAsState(0)
    val seguidos: Int by viewModel.seguidos.observeAsState(0)
    viewModel.setPokemons()
    viewModel.setImagenes(userId)
    viewModel.setSeguidores(userId)
    viewModel.setSeguidos(userId)

    val usuarioLogeado = UserService.getUserNameById(userId)

    val selectedTabIndex = remember { mutableStateOf(0) }

    Column {
        Text(
            text = "Usuario: $usuarioLogeado", // Mostrar el nombre del usuario logeado
            modifier = Modifier.padding(16.dp)
        )
        TabRow(
            selectedTabIndex = selectedTabIndex.value,
            modifier = Modifier.fillMaxWidth()
        ) {
            Tab(
                selected = isTabSelected(0, selectedTabIndex.value),
                onClick = {
                    selectedTabIndex.value = 0
                },
                text = { Text("Seguidores: $seguidores") }
            )
            Tab(
                selected = isTabSelected(1, selectedTabIndex.value),
                onClick = {
                    selectedTabIndex.value = 1
                },
                text = { Text("Seguidos: $seguidos") }
            )
        }

        LazyVerticalGrid(
            modifier = Modifier.fillMaxSize(),
            columns = GridCells.Fixed(5),
            content = {
                // Obtener listas de seguidores y seguidos por ID de usuario
                val seguidoresList = viewModel.getSeguidores(userId)
                val seguidosList = viewModel.getSeguidos(userId)

                // Mostrar imágenes de seguidores si el tab seleccionado es "Seguidores"
                if (isTabSelected(0, selectedTabIndex.value)) {
                    items(seguidoresList.size) { index ->
                        val seguidor: Seguidor = seguidoresList[index]
                        Image(
                            painter = rememberImagePainter(data = seguidor.imageUrl),
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp)
                                .padding(bottom = 10.dp)
                                .clickable { goToFollowerScreen(userId) }
                        )
                    }
                }

                // Mostrar imágenes de seguidos si el tab seleccionado es "Seguidos"
                if (isTabSelected(1, selectedTabIndex.value)) {
                    items(seguidosList.size) { index ->
                        val seguidos: Seguido = seguidosList[index]
                        Image(
                            painter = rememberImagePainter(data = seguidos.imageUrl),
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp)
                                .padding(bottom = 10.dp)
                                .clickable { /* Manejar evento de clic en la imagen de seguido */ }
                        )
                    }
                }
            }
        )
    }
}

private fun isTabSelected(index: Int, selectedTabIndex: Int): Boolean {
    return index == selectedTabIndex
}









