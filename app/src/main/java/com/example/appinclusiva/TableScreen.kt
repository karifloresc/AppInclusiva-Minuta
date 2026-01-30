package com.example.appinclusiva

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

data class TableUser(
    val name: String,
    val email: String
)

@Composable
fun TableScreen() {

    // Datos de ejemplo (después podemos conectar con tu Register)
    val users = listOf(
        TableUser("Kari", "kari@email.com"),
        TableUser("Ana", "ana@email.com"),
        TableUser("Pedro", "pedro@email.com"),
        TableUser("Sofi", "sofi@email.com")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Tabla (Semana 3)", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(12.dp))

        Card {
            Column(modifier = Modifier.fillMaxWidth().padding(12.dp)) {

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

                // Filas tabla
                LazyColumn {
                    items(users) { u ->
                        Row(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
                            Text(u.name, modifier = Modifier.weight(1f))
                            Text(u.email, modifier = Modifier.weight(2f))
                        }
                        Divider()
                    }
                }
            }
        }
    }
}