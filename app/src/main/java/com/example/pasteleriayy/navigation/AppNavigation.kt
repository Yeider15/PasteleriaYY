package com.example.pasteleriayy.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.pasteleriayy.ui.components.BottomNavBar
import com.example.pasteleriayy.ui.screens.MenuProductosScreen

// Definición simple de rutas para evitar errores de escritura
object AppScreens {
    const val MENU = "menu"
    const val REGISTRO = "registro"
    const val CONTACTO = "contacto"
    const val PROMOCIONES = "promociones"
}

@Composable
fun AppNavigation() {
    // 1. Crear el controlador de navegación (necesario solo una vez)
    val navController = rememberNavController()

    // 2. Definir el NavHost con todas las rutas
    NavHost(
        navController = navController,
        startDestination = AppScreens.MENU // Inicia siempre en el menú
    ) {
        // --- Ruta: MENÚ ---
        composable(AppScreens.MENU) {
            MenuProductosScreen(navController = navController)
        }

        // --- Rutas Placeholders (Usan la pantalla genérica) ---

        // Ruta: REGISTRO
        composable(AppScreens.REGISTRO) {
            SimplePlaceholderScreen(title = "Registro", navController = navController)
        }

        // Ruta: CONTACTO
        composable(AppScreens.CONTACTO) {
            SimplePlaceholderScreen(title = "Contacto", navController = navController)
        }

        // Ruta: PROMOCIONES
        composable(AppScreens.PROMOCIONES) {
            SimplePlaceholderScreen(title = "Promociones", navController = navController)
        }
    }
}

// --- Componente BÁSICO para las pantallas aún no construidas (Placeholder) ---
// Su ÚNICA función es mostrar el BottomNavBar y un texto simple.
@Composable
fun SimplePlaceholderScreen(title: String, navController: NavController) {
    // Necesitamos obtener la ruta actual para que el BottomNavBar funcione
    val navBackStackEntry = navController.currentBackStackEntryAsState().value
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            BottomNavBar(navController = navController, currentRoute = currentRoute)
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Pantalla de $title en construcción.")
        }
    }
}