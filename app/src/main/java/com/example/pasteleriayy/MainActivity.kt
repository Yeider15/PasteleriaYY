import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.pasteleriayy.navigation.AppNavigation
import com.example.pasteleriayy.ui.components.BottomNavBar
import com.example.pasteleriayy.ui.theme.PasteleriaYYTheme // Importa tu tema

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PasteleriaYYTheme {
                // Llama al componente que maneja la estructura principal
                MainAppStructure()
            }
        }
    }
}

@Composable
fun MainAppStructure() {
    // 1. Crea el NavController aquí (controlador único)
    val navController = rememberNavController()

    // 2. Obtiene la ruta actual para que el BottomNavBar sepa qué seleccionar
    val navBackStackEntry = navController.currentBackStackEntryAsState().value
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        // 3. Define el BottomNavBar en el esqueleto principal (fijo)
        bottomBar = {
            BottomNavBar(navController = navController, currentRoute = currentRoute)
        }
    ) { paddingValues ->
        // 4. Llama a AppNavigation, pasando el controlador y el padding
        AppNavigation(
            navController = navController,
            modifier = Modifier.padding(paddingValues) // Esto asegura que el contenido no se oculte detrás de la barra
        )
    }
}