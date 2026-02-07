package com.example.appinclusiva.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.appinclusiva.data.repository.UsuariosRepository

@Composable
fun TableScreen() {

    // Fuente única de datos (Repository)
    val users = UsuariosRepository.obtenerUsuarios()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Tabla de Usuarios", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(12.dp))

        Card {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {

                // Encabezado tabla
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        "Nombre",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f)
                    )
                    Text(
                        "Email",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(2f)
                    )
                }

                Divider(modifier = Modifier.padding(vertical = 8.dp))

                // Filas tabla (usa el repo)
                LazyColumn {
                    items(users) { u ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp)
                        ) {
                            Text(u.nombre, modifier = Modifier.weight(1f))
                            Text(u.email, modifier = Modifier.weight(2f))
                        }
                        Divider()
                    }
                }
            }
        }
    }
}
