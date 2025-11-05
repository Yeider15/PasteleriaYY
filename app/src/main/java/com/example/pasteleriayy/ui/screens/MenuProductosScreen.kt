package com.example.pasteleriayy.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.pasteleriayy.ui.components.BottomNavBar
import com.example.pasteleriayy.ui.components.ProductoItem
import com.example.pasteleriayy.viewmodel.MenuViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuProductosScreen(
    navController: NavController,
    // El 'viewModel()' automáticamente crea/reutiliza el MenuViewModel
    menuViewModel: MenuViewModel = viewModel()
) {
    // --- Lógica de Navegación para la Barra Inferior ---
    // 1. Obtiene la ruta actual para saber qué ítem resaltar en el BottomNavBar.
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    // 2. Obtiene la lista de productos del ViewModel
    val productos = menuViewModel.productos

    // --- Estructura de la Pantalla ---
    Scaffold(
        // Barra Superior
        topBar = {
            TopAppBar(
                title = { Text("Nuestro Menú de Postres") },
                colors = TopAppBarDefaults.topAppBarColors(
                    // Aplicamos los colores de tu tema
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },
        // Barra Inferior
        bottomBar = {
            // 3. Integra el BottomNavBar
            BottomNavBar(
                navController = navController,
                currentRoute = currentRoute
            )
        }
    ) { paddingValues ->

        // --- Contenido Principal (Lista de Productos) ---
        LazyColumn(
            // Aplica el padding para no ocultar contenido bajo las barras
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 4.dp)
        ) {
            // 4. Itera sobre la lista del ViewModel
            items(productos) { producto ->
                // 5. Usa el componente ProductoItem para dibujar cada elemento
                ProductoItem(
                    producto = producto,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
            }
        }
    }
}