package com.example.pasteleriayy.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pasteleriayy.R
import com.example.pasteleriayy.ui.theme.Crema

/**
 * Formulario de contacto con validación y logo de la pastelería.
 * Estructura basada en el código del profesor.
 */
@Composable
fun ContactoScreen(modifier: Modifier = Modifier) {
    // Campos del formulario
    var nombre by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var mensaje by remember { mutableStateOf("") }
    // Errores
    var nombreError by remember { mutableStateOf("") }
    var correoError by remember { mutableStateOf("") }
    var telefonoError by remember { mutableStateOf("") }
    var mensajeError by remember { mutableStateOf("") }

    // Mensaje de éxito
    var mensajeExito by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Crema)
            .systemBarsPadding()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo ",
            modifier = Modifier
                .size(140.dp)
                .padding(top = 24.dp),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Título
        Text(
            text = "Formulario de Contacto",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Campo nombre
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
            Text(text = nombreError, color = Color.Red)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Campo correo
        OutlinedTextField(
            value = correo,
            onValueChange = {
                correo = it
                correoError = ""
            },
            label = { Text("Correo") },
            isError = correoError.isNotEmpty(),
            modifier = Modifier.fillMaxWidth()
        )
        if (correoError.isNotEmpty()) {
            Text(text = correoError, color = Color.Red)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Campo teléfono
        OutlinedTextField(
            value = telefono,
            onValueChange = {
                telefono = it
                telefonoError = ""
            },
            label = { Text("Teléfono") },
            isError = telefonoError.isNotEmpty(),
            modifier = Modifier.fillMaxWidth()
        )
        if (telefonoError.isNotEmpty()) {
            Text(text = telefonoError, color = Color.Red)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Campo mensaje
        OutlinedTextField(
            value = mensaje,
            onValueChange = {
                mensaje = it
                mensajeError = ""
            },
            label = { Text("Mensaje") },
            isError = mensajeError.isNotEmpty(),
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        )
        if (mensajeError.isNotEmpty()) {
            Text(text = mensajeError, color = Color.Red)
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Botón enviar
        Button(
            onClick = {
                // Limpiar mensajes previos
                nombreError = ""
                correoError = ""
                telefonoError = ""
                mensajeError = ""
                mensajeExito = ""

                // Validaciones básicas
                if (nombre.isBlank()) nombreError = "El nombre no puede estar vacío"
                if (correo.isBlank()) correoError = "El correo no puede estar vacío"
                else if (!correo.contains("@")) correoError = "Correo inválido"
                if (telefono.isBlank()) telefonoError = "El teléfono no puede estar vacío"
                if (mensaje.isBlank()) mensajeError = "Debe escribir un mensaje"

                // Si no hay errores
                if (nombreError.isEmpty() && correoError.isEmpty() &&
                    telefonoError.isEmpty() && mensajeError.isEmpty()
                ) {
                    mensajeExito = "Mensaje enviado correctamente 🎉"
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Enviar")
        }

        // Mensaje de éxito
        if (mensajeExito.isNotEmpty()) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = mensajeExito, color = Color(0xFF388E3C))
        }
    }
}
