package com.example.pasteleriayy.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pasteleriayy.ui.screens.ContactoScreen
import com.example.pasteleriayy.ui.screens.MenuProductosScreen
import com.example.pasteleriayy.ui.screens.FormularioValidacion

object AppScreens {
    const val MENU = "menu"
    const val REGISTRO = "registro"
    const val CONTACTO = "contacto"
    const val PROMOCIONES = "promociones"
}

@Composable
fun AppNavigation(navController: NavHostController, modifier: Modifier = Modifier) {

    NavHost(
        navController = navController,
        startDestination = AppScreens.MENU, // Inicia siempre en el menú
        modifier = modifier // Aplicar el padding para no chocar con la BottomNavBar
    ) {
        composable(AppScreens.MENU) {
            MenuProductosScreen(navController = navController)
        }

        composable(AppScreens.REGISTRO) {
            // Llamada directa al formulario
            FormularioValidacion(navController = navController)
        }

        composable(AppScreens.CONTACTO) {
            ContactoScreen(navController = navController)
        }

        // Ruta: PROMOCIONES
        composable(AppScreens.PROMOCIONES) {
            SimplePlaceholderScreenContent(title = "Promociones")
        }
    }
}

@Composable
fun SimplePlaceholderScreenContent(title: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Pantalla de $title en construcción.")
    }
}