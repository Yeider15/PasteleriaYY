package com.example.pasteleriayy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.pasteleriayy.navigation.AppNavigation
import com.example.pasteleriayy.ui.theme.PasteleriaApp_P2Theme // Importa tu tema

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Establecer el contenido de la actividad
        setContent {
            // 1. Aplicamos el tema a toda la aplicación
            PasteleriaApp_P2Theme {
                // 2. Llamamos al componente de navegación principal, que renderiza la primera pantalla.
                AppNavigation()
            }
        }
    }
}