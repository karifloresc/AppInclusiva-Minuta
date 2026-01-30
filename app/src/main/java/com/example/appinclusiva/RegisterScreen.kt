package com.example.appinclusiva

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll



@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun RegisterScreen(onBackToLogin: () -> Unit) {


    var nombre by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    // Para el ComboBox
    var metodoComunicacion by remember { mutableStateOf("Texto") }
    val opcionesMetodo = listOf("Texto", "Pictogramas", "Frases rápidas")

    // Para los CheckBox
    var letraGrande by remember { mutableStateOf(false) }
    var altoContraste by remember { mutableStateOf(false) }

    // Para los RadioButtons
    var tamanoTexto by remember { mutableStateOf("Grande") }

    val scrollState = rememberScrollState()
    val users = remember {
        mutableStateListOf(
            User("Quinn", "quinn@gmail.com", "Texto", true, false, "Grande"),
            User("Fernando", "fernando@gmail.com", "Pictogramas", false, true, "Extra grande"),
            User("Sergio", "sergio@gmail.com", "Frases rápidas", true, true, "Grande"),
            User("Sandra", "sandra@gmail.com", "Texto", false, false, "Grande"),
            User("Yumi", "yumi@gmail.com", "Pictogramas", true, false, "Extra grande")
        )
    }


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
                modifier = Modifier.menuAnchor().fillMaxWidth()
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

        Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
            Checkbox(
                checked = letraGrande,
                onCheckedChange = { letraGrande = it }
            )
            Text("Letra grande")
        }

        Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
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

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                users.add(
                    User(
                        nombre = nombre,
                        email = email,
                        metodoComunicacion = metodoComunicacion,
                        letraGrande = letraGrande,
                        altoContraste = altoContraste,
                        tamanoTexto = tamanoTexto
                    )
                )

                nombre = ""
                email = ""
                password = ""

                onBackToLogin() // ✅ volver al Login
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

