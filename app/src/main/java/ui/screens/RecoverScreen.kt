package com.example.appinclusiva.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.appinclusiva.data.repository.UsuariosRepository

@Composable
fun RecoverScreen(onBackToLogin: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var mensaje by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Recuperar contraseña", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        if (mensaje.isNotBlank()) {
            Text(
                text = mensaje,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                val e = email.trim()

                if (e.isBlank()) {
                    mensaje = "Ingresa tu email."
                    return@Button
                }

                val usuario = UsuariosRepository.buscarPorEmail(e)
                mensaje = if (usuario != null) {
                    "Se envió un correo a $e ✅"
                } else {
                    "Email no registrado ❌"
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Enviar")
        }

        Spacer(modifier = Modifier.height(8.dp))

        TextButton(onClick = onBackToLogin) {
            Text("Volver al Login")
        }
    }
}
