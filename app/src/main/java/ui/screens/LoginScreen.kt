package com.example.appinclusiva.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import com.example.appinclusiva.data.repository.UsuariosRepository

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    onRegisterClick: () -> Unit,
    onRecoverClick: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var mensaje by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Login", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                    unfocusedIndicatorColor = MaterialTheme.colorScheme.outline
                )
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Contraseña") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                    unfocusedIndicatorColor = MaterialTheme.colorScheme.outline
                )
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        if (mensaje.isNotBlank()) {
            Text(
                text = mensaje,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                val e = email.trim()
                val p = password

                if (e.isBlank() || p.isBlank()) {
                    mensaje = "Ingresa email y contraseña."
                    return@Button
                }

                val usuario = UsuariosRepository.buscarPorEmail(e)

                if (usuario != null && usuario.password == p) {
                    mensaje = ""
                    onLoginSuccess()
                } else {
                    mensaje = "Credenciales incorrectas ❌"
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ingresar")
        }

        Spacer(modifier = Modifier.height(12.dp))

        TextButton(
            onClick = onRegisterClick,
            colors = ButtonDefaults.textButtonColors(
                contentColor = MaterialTheme.colorScheme.onSurface
            )
        ) {
            Text("Crear cuenta")
        }

        TextButton(
            onClick = onRecoverClick,
            colors = ButtonDefaults.textButtonColors(
                contentColor = MaterialTheme.colorScheme.onSurface
            )
        ) {
            Text("¿Olvidaste tu contraseña?")
        }
    }
}
