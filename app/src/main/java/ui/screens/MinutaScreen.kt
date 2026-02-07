package com.example.appinclusiva.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.appinclusiva.data.model.Receta

@Composable
fun MinutaScreen(
    onBack: () -> Unit
) {
    // 🔑 SEMANA 4: Array/List en Kotlin con 5 recetas
    val recetas = listOf(
        Receta("Lunes", "Ensalada de pollo", "Alta en proteína y baja en grasas"),
        Receta("Martes", "Lentejas con verduras", "Alta en fibra y hierro"),
        Receta("Miércoles", "Pescado al horno", "Rico en omega-3 y bajo en sodio"),
        Receta("Jueves", "Tortilla de espinaca", "Aporta vitaminas y saciedad"),
        Receta("Viernes", "Yogur con fruta y avena", "Energía estable y buena digestión")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Minuta nutricional semanal",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Recomendación diaria de alimentación saludable.",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(recetas) { receta ->
                ElevatedCard(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = receta.dia,
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = receta.nombre,
                            style = MaterialTheme.typography.titleMedium
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "Recomendación: ${receta.recomendacion}",
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
        }

        Button(
            onClick = onBack,
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
        ) {
            Text("Volver")
        }
    }
}
