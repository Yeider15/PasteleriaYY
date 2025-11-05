package com.example.pasteleriayy.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AppRegistration
import androidx.compose.material.icons.filled.ContactMail
import androidx.compose.material.icons.filled.Discount
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
data class NavItem(
    val route: String,
    val label: String,
    val icon: ImageVector
)

private val navItems = listOf(
    NavItem("registro", "Registro", Icons.Filled.AppRegistration),
    NavItem("menu", "Menú", Icons.Filled.Fastfood),
    NavItem("contacto", "Contacto", Icons.Filled.ContactMail),
    NavItem("promociones", "Promociones", Icons.Filled.Discount)
)

@Composable
fun BottomNavBar(
    navController: NavController,
    currentRoute: String? = null
) {
    val itemColors = NavigationBarItemDefaults.colors(
        unselectedTextColor = MaterialTheme.colorScheme.onPrimary,
        unselectedIconColor = MaterialTheme.colorScheme.onPrimary,
        selectedTextColor = MaterialTheme.colorScheme.onPrimary,
        selectedIconColor = MaterialTheme.colorScheme.onPrimary,
        indicatorColor = MaterialTheme.colorScheme.primary
    )

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.primary, // Fondo: Rosa Pastel
    ) {
        navItems.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                colors = itemColors
            )
        }
    }
}