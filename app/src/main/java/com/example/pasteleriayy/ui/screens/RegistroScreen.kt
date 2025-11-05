package com.example.pasteleriayy.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pasteleriayy.model.Usuario

@Composable
fun FormularioValidacion(navController: NavController, modifier: Modifier = Modifier) {
    // Estados para los valores de los campos
    var nombre by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var contrasena by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }

    // Estados para los mensajes de error
    var nombreError by remember { mutableStateOf("") }
    var correoError by remember { mutableStateOf("") }
    var contrasenaError by remember { mutableStateOf("") }

    // Estado para el mensaje de éxito
    var mensajeExito by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //  TÍTULO DE LA PANTALLA
        Text(
            text = "Registro de Usuario",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF6200EE),
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Campo de nombre
        OutlinedTextField(
            value = nombre,
            onValueChange = {
                nombre = it
                nombreError = ""
            },
            label = { Text("Nombre") },
            isError = nombreError.isNotEmpty(),
            modifier = Modifier.fillMaxWidth()
        )

        if (nombreError.isNotEmpty()) {
            Text(
                text = nombreError,
                color = Color.Red,
                modifier = Modifier.padding(start = 16.dp, top = 4.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Campo de correo
        OutlinedTextField(
            value = correo,
            onValueChange = {
                correo = it
                correoError = ""
            },
            label = { Text("Correo electrónico") },
            isError = correoError.isNotEmpty(),
            modifier = Modifier.fillMaxWidth()
        )

        if (correoError.isNotEmpty()) {
            Text(
                text = correoError,
                color = Color.Red,
                modifier = Modifier.padding(start = 16.dp, top = 4.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Campo de contraseña
        OutlinedTextField(
            value = contrasena,
            onValueChange = {
                contrasena = it
                contrasenaError = ""
            },
            label = { Text("Contraseña") },
            isError = contrasenaError.isNotEmpty(),
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        if (contrasenaError.isNotEmpty()) {
            Text(
                text = contrasenaError,
                color = Color.Red,
                modifier = Modifier.padding(start = 16.dp, top = 4.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Campo de teléfono (opcional)
        OutlinedTextField(
            value = telefono,
            onValueChange = { telefono = it },
            label = { Text("Teléfono (opcional)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Botón para enviar
        Button(
            onClick = {
                // Limpiar errores y mensaje previo
                nombreError = ""
                correoError = ""
                contrasenaError = ""
                mensajeExito = ""

                // Validar campos
                if (nombre.isBlank()) {
                    nombreError = "El nombre no puede estar vacío"
                }
                if (correo.isBlank()) {
                    correoError = "El correo no puede estar vacío"
                } else if (!correo.contains("@") || !correo.contains(".")) {
                    correoError = "El correo no es válido"
                }
                if (contrasena.isBlank()) {
                    contrasenaError = "La contraseña no puede estar vacía"
                } else if (contrasena.length < 6) {
                    contrasenaError = "Debe tener al menos 6 caracteres"
                }

                // Si no hay errores, crear el usuario
                if (nombreError.isEmpty() && correoError.isEmpty() && contrasenaError.isEmpty()) {
                    val usuario = Usuario(
                        nombre = nombre,
                        correo = correo,
                        contrasena = contrasena,
                        telefono = if (telefono.isNotBlank()) telefono else null
                    )

                    mensajeExito = "Usuario ${usuario.nombre} registrado correctamente"
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Registrar Usuario")
        }

        // Mensaje de éxito
        if (mensajeExito.isNotEmpty()) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = mensajeExito,
                color = Color.Green,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}
