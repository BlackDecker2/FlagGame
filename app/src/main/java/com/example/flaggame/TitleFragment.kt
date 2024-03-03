package com.example.flaggame

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun TitleScreen(
    navController: NavController,
    onLevelSelected: (Difficulty) -> Unit // Callback para manejar la selección del nivel
) {
    var selectedLevel by remember { mutableStateOf<Difficulty?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Acierta la bandera!",
            style = MaterialTheme.typography.h4,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Button(
            onClick = { selectedLevel = Difficulty.EASY }, // Establece el nivel seleccionado como Fácil
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Text(text = "Facil")
        }

        Button(
            onClick = { selectedLevel = Difficulty.MEDIUM }, // Establece el nivel seleccionado como Intermedio
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Text(text = "Intermedio")
        }

        Button(
            onClick = { selectedLevel = Difficulty.HARD }, // Establece el nivel seleccionado como Difícil
        ) {
            Text(text = "Difícil")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                selectedLevel?.let { level ->
                    onLevelSelected(level) // Llama al callback con el nivel seleccionado
                    when (level) {
                        Difficulty.EASY -> navController.navigate("easyFragment")
                        Difficulty.MEDIUM, Difficulty.HARD -> navController.navigate("gameFragment")
                    }
                }
            }
        ) {
            Text(text = "Comenzar")
        }
    }
}
