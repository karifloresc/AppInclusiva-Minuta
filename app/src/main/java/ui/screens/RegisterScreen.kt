package com.example.appinclusiva.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.appinclusiva.data.model.Usuario
import com.example.appinclusiva.data.repository.UsuariosRepository

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(onBackToLogin: () -> Unit) {

    var nombre by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    // ComboBox
    var metodoComunicacion by remember { mutableStateOf("Texto") }
    val opcionesMetodo = listOf("Texto", "Pictogramas", "Frases rápidas")

    // CheckBox
    var letraGrande by remember { mutableStateOf(false) }
    var altoContraste by remember { mutableStateOf(false) }

    // RadioButtons
    var tamanoTexto by remember { mutableStateOf("Grande") }

    // Mensaje UI (éxito / error)
    var mensaje by remember { mutableStateOf("") }

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(24.dp)
    ) {
        Text(
            text = "Registro de usuario",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        //  COMBO BOX
        Text("Método de comunicación")
        var expanded by remember { mutableStateOf(false) }

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            OutlinedTextField(
                value = metodoComunicacion,
                onValueChange = {},
                readOnly = true,
                label = { Text("Selecciona") },
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                opcionesMetodo.forEach { opcion ->
                    DropdownMenuItem(
                        text = { Text(opcion) },
                        onClick = {
                            metodoComunicacion = opcion
                            expanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // CHECK LIST
        Text("Opciones de accesibilidad")

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = letraGrande,
                onCheckedChange = { letraGrande = it }
            )
            Text("Letra grande")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = altoContraste,
                onCheckedChange = { altoContraste = it }
            )
            Text("Alto contraste")
        }

        Spacer(modifier = Modifier.height(20.dp))

        // RADIO BUTTONS
        Text("Tamaño de texto")

        Row {
            RadioButton(
                selected = tamanoTexto == "Grande",
                onClick = { tamanoTexto = "Grande" }
            )
            Text("Grande")

            Spacer(modifier = Modifier.width(16.dp))

            RadioButton(
                selected = tamanoTexto == "Extra grande",
                onClick = { tamanoTexto = "Extra grande" }
            )
            Text("Extra grande")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Mensaje (si existe)
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
                val n = nombre.trim()
                val e = email.trim()
                val p = password

                if (n.isBlank() || e.isBlank() || p.isBlank()) {
                    mensaje = "Completa nombre, email y contraseña."
                    return@Button
                }

                val nuevoUsuario = Usuario(
                    nombre = n,
                    email = e,
                    password = p
                )

                val registrado = UsuariosRepository.registrar(nuevoUsuario)

                if (registrado) {
                    mensaje = "Usuario guardado ✅"

                    // limpiar campos
                    nombre = ""
                    email = ""
                    password = ""

                    onBackToLogin() // volver al Login
                } else {
                    mensaje = "Ese email ya está registrado ❌"
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar usuario")
        }

        Spacer(modifier = Modifier.height(8.dp))

        TextButton(onClick = onBackToLogin) {
            Text("Volver al Login")
        }

        Spacer(modifier = Modifier.height(8.dp))
    }
}
