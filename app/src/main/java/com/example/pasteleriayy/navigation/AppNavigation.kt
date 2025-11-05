package com.example.pasteleriayy.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController // Importar NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
// ⚠️ Eliminamos todos los imports de Scaffold, rememberNavController, currentBackStackEntryAsState, etc.
import com.example.pasteleriayy.ui.screens.MenuProductosScreen
import com.example.pasteleriayy.ui.screens.FormularioValidacion

// Definición simple de rutas para evitar errores de escritura
object AppScreens {
    const val MENU = "menu"
    const val REGISTRO = "registro"
    const val CONTACTO = "contacto"
    const val PROMOCIONES = "promociones"
}

@Composable
// Esta función recibe el NavController y el Modifier (con el padding) desde MainActivity
fun AppNavigation(navController: NavHostController, modifier: Modifier = Modifier) {

    // ⚠️ CRUCIAL: ELIMINAR LA CREACIÓN DEL NAVCONTROLLER AQUÍ.
    // Ya viene como parámetro desde el componente superior.

    NavHost(
        navController = navController,
        startDestination = AppScreens.MENU, // Inicia siempre en el menú
        modifier = modifier // Aplicar el padding para no chocar con la BottomNavBar
    ) {
        // --- Ruta: MENÚ ---
        composable(AppScreens.MENU) {
            MenuProductosScreen(navController = navController)
        }

        // --- Ruta: REGISTRO ---
        composable(AppScreens.REGISTRO) {
            // Llamada directa al formulario
            FormularioValidacion(navController = navController)
        }

        // Ruta: CONTACTO
        composable(AppScreens.CONTACTO) {
            SimplePlaceholderScreenContent(title = "Contacto")
        }

        // Ruta: PROMOCIONES
        composable(AppScreens.PROMOCIONES) {
            SimplePlaceholderScreenContent(title = "Promociones")
        }
    }
}

// --- Componente BÁSICO para las pantallas aún no construidas (Contenido sin Scaffold) ---
@Composable
fun SimplePlaceholderScreenContent(title: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Pantalla de $title en construcción.")
    }
}